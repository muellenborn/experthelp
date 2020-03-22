package org.wirvsvirus.expertexchange.service.boot.config;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.wirvsvirus.expertexchange.service.model.KnowHow;
import org.wirvsvirus.expertexchange.service.repositories.KnowHowCategoryRepository;
import org.wirvsvirus.expertexchange.service.srv.IMetadataService;
import org.wirvsvirus.expertexchange.service.srv.MetadataService;

@Configuration
@EnableAsync
@EnableScheduling
@EnableAutoConfiguration
@EnableJpaRepositories("org.wirvsvirus.expertexchange.service.repositories")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {
		"org.wirvsvirus.expertexchange.service.boot",
		"org.wirvsvirus.expertexchange.service.boot.config",
		"org.wirvsvirus.expertexchange.service.repositories",
		"org.wirvsvirus.expertexchange.service.controller",
		"org.wirvsvirus.expertexchange.service.model",
		"org.wirvsvirus.expertexchange.service.srv"
})
public class SpringConfig implements WebMvcConfigurer, SchedulingConfigurer {
	private static final Logger log = LoggerFactory.getLogger(SpringConfig.class);

	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(20);
		executor.setThreadNamePrefix("SpringTaskExecutorThread-");
		executor.initialize();

		return executor;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setThreadNamePrefix("SpringTaskSchedulerThread-");
		taskScheduler.setPoolSize(20);
		taskScheduler.initialize();

		taskRegistrar.setTaskScheduler(taskScheduler);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*.html").setCacheControl(CacheControl.noCache()).addResourceLocations("/");
		registry.addResourceHandler("/**").setCacheControl(CacheControl.noCache()).addResourceLocations("/");
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding(StandardCharsets.UTF_8.displayName());

		return commonsMultipartResolver;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentTypeStrategy(new HeaderContentNegotiationStrategy());
		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8, MediaType.ALL);
		configurer.ignoreAcceptHeader(true);
		configurer.favorPathExtension(false);
		configurer.favorParameter(false);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ByteArrayHttpMessageConverter baHttpMessageConverter = new ByteArrayHttpMessageConverter();
		baHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);

		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);

		converters.add(mappingJacksonMessageConverter());
		converters.add(mappingXmlMessageConverter());
		converters.add(baHttpMessageConverter);
		converters.add(stringHttpMessageConverter);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseRegisteredSuffixPatternMatch(false);
		configurer.setUseSuffixPatternMatch(false);
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setDefaultCharset(StandardCharsets.UTF_8);
		converter.setObjectMapper(objectMapper());
		converter.setPrettyPrint(true);

		return converter;
	}

	@Bean
	public Jaxb2RootElementHttpMessageConverter mappingXmlMessageConverter() {
		Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
		converter.setDefaultCharset(StandardCharsets.UTF_8);

		return converter;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
		objectMapper.setSerializationInclusion(Include.NON_NULL);

		return objectMapper;
	}

	@Autowired
	KnowHowCategoryRepository knowHowCategoryRepository;

	@Autowired
	MetadataService metadataService;

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes(true);
	}
}
