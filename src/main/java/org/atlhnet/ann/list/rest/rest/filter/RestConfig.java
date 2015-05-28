package org.atlhnet.ann.list.rest.rest.filter;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {

	@Bean
	public Filter simpleCorsFilter() {
		return new SimpleCORSFilter();
	}

}
