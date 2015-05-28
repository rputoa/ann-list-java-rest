package org.atlhnet.ann.list.rest.dao;

import org.apache.commons.lang3.StringUtils;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimeListDao {

	private final static String ANN_LIST_REPORT = "http://www.animenewsnetwork.com/encyclopedia/reports.xml?id=155&type=anime";
	private final static String URL_START_PARAM = "&nskip=";
	private final static String URL_LIMIT_PARAM = "&nlist=";
	private final static String URL_NAME_PARAM = "&name=";

	@Autowired
	private ANNRetriever annRetriever;

	/** Retrieve list of anime from the retriever */
	public AnimeList getList(final Integer start, final Integer limit,
			final String name) {

		return annRetriever.retrieveData(
				getUrlWithParamForAnimeList(start, limit, name),
				AnimeList.class);
	}

	/**
	 * This method build the URL Adress needed to call ANN API for retrieving
	 * the list of anime
	 *
	 * @param start
	 *            number of anime to skip in the listing
	 * @param limit
	 *            numer of anime to display in the listing
	 * @param name
	 *            anime in listing must begin with this String
	 * @return
	 */
	private String getUrlWithParamForAnimeList(final Integer start,
			final Integer limit, final String name) {

		final StringBuilder urlWithParam = new StringBuilder();
		urlWithParam.append(ANN_LIST_REPORT);// ,

		// Add start Parameter
		if (start != null) {
			final String startParam = URL_START_PARAM + start.toString();
			urlWithParam.append(startParam);
		}

		// Add limit Parameter
		if (limit != null) {
			final String limitParam = URL_LIMIT_PARAM + limit.toString();
			urlWithParam.append(limitParam);
		}

		// Add name Parameter
		if (StringUtils.isNotBlank(name)) {
			final String nameParam = URL_NAME_PARAM + name;
			urlWithParam.append(nameParam);
		}

		return urlWithParam.toString();
	}
}
