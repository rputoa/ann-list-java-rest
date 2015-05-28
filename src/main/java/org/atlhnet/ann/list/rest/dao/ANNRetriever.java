package org.atlhnet.ann.list.rest.dao;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

/**
 * Helper class for accessing Anime News Network API
 * 
 * @author IPPON
 *
 */

@Component
public class ANNRetriever {

	/**
	 * Retrieve an xml response from an URL and unmarshall it into POJO
	 * 
	 * @param uri
	 * @param type
	 * @return
	 */
	public <T> T retrieveData(final String uri, final Class<T> type) {

		T result = null;
		try {
			final URL url = new URL(uri);
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(type);
			final Unmarshaller jaxbUnmarshaller = jaxbContext
					.createUnmarshaller();

			result = type.cast(jaxbUnmarshaller.unmarshal(url));
		} catch (final JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
}
