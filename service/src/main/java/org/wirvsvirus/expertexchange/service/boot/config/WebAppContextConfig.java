package org.wirvsvirus.expertexchange.service.boot.config;

import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author bahlef
 */
@Configuration
public class WebAppContextConfig {
	@Bean
	public DispatcherServletRegistrationBean dispatcherServletRegistration(WebApplicationContext context) {
		DispatcherServletRegistrationBean registration = new DispatcherServletRegistrationBean(new DispatcherServlet(context), "/api/*");
		registration.addInitParameter("contextConfigLocation", "classpath*:spring/applicationContext.xml");
		registration.setLoadOnStartup(1);
		registration.setName("dispatcherServlet");

		return registration;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
		FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<>();
		registration.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST));
		registration.setMatchAfter(true);
		registration.setFilter(new CorsFilter());
		registration.addUrlPatterns("/*");
		registration.setName("corsFilter");
		registration.setOrder(2);

		return registration;
	}

	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilterRegistration() {
		FilterRegistrationBean<CharacterEncodingFilter> registration = new FilterRegistrationBean<>();
		registration.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST));
		registration.setMatchAfter(true);
		registration.setFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName()));
		registration.addUrlPatterns("/*");
		registration.setName("characterEncodingFilter");
		registration.setOrder(3);

		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> httpSessionListenerRegistration() {
		return new ServletListenerRegistrationBean<>(new SessionListener());
	}
}
