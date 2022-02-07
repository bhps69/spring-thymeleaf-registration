package com.example.springbootExample;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class WebConfig extends WebSecurityConfiguration {

	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:validation");
		bundleMessageSource.setDefaultEncoding("UTF-18");
		return bundleMessageSource;
	}

}
