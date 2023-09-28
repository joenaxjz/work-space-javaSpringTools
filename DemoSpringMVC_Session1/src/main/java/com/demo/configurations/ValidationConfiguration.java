package com.demo.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ValidationConfiguration {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource src = new ResourceBundleMessageSource();
		src.setBasename("errors");
		return src;
	}
}
