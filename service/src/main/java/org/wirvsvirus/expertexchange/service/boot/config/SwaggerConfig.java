package org.wirvsvirus.expertexchange.service.boot.config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author bahlef
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api(ServletContext servletContext) {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(Predicates.not(PathSelectors.regex("^(/actuator|/cloudfoundryapplication|/error).*$")))
				.apis(RequestHandlerSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API documentation")
				.contact(new Contact("expertexchange", "https://exex.eu-gb.cf.appdomain.cloud/", "nospam@us.thx"))
				.version("0.0.1").build();
	}
}
