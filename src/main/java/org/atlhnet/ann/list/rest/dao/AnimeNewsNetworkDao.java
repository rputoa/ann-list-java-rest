package org.atlhnet.ann.list.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AnimeNewsNetworkDao {

	@Autowired
	private RestTemplate restTemplate;

	@Before
	public void setup() {
		// Add XML Message Converter to restTemplate;
		final List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new Jaxb2RootElementHttpMessageConverter());
		restTemplate.setMessageConverters(converters);
	}

	/**
	 * Return an unmarshalled object from URL
	 * 
	 * @param uri
	 * @param type
	 * @return
	 */
	public <T> T retrieveData(final String uri, final Class<T> type) {

		return restTemplate.getForObject(uri, type);
	}

}
