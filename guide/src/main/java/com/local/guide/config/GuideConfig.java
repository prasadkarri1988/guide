package com.local.guide.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.SerializationFeature;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class GuideConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.local.guide")).build();
	}

	/*@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonCustomConfig() {
		return builder -> {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			builder.failOnEmptyBeans(false);
			builder.indentOutput(true);
			builder.failOnEmptyBeans(false).failOnUnknownProperties(false)
					.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).dateFormat(df);
		};
	}*/
}
