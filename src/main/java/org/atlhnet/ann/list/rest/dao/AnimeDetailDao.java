package org.atlhnet.ann.list.rest.dao;

import org.apache.commons.lang3.StringUtils;
import org.atlhnet.ann.list.rest.domain.AnimeDetail;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.atlhnet.ann.list.rest.domain.mapper.AnimeListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AnimeDetailDao {

	private final static String ANN_LIST_DETAIL = "http://www.animenewsnetwork.com/encyclopedia/api.xml?anime=";

	@Autowired
	private ANNRetriever annRetriever;

	@Cacheable(value = "getAnimeDetail", key = "#id")
	public AnimeDetail getAnimeDetail(final Long id) {
		slowQuery(5000L);
		AnimeDetail anime = null;
		if (id != null) {
			anime = annRetriever.retrieveData(
					getUrlWithParamForAnimeDetail(id), AnimeDetail.class);
		}
		return anime;
	}

	@Cacheable(value = "getAnimeDetail", key = "#name")
	public AnimeList getAnimeListByName(final String name) {
		AnimeList animeList = null;
		if (StringUtils.isNotBlank(name)) {
			// Retrieve list of anime by name with full detail
			final AnimeDetail animeDetail = annRetriever.retrieveData(
					getUrlWithParamForAnimeListByName(name), AnimeDetail.class);
			// Convert into AnimeList
			animeList = AnimeListMapper.mapFromAnimeDetail(animeDetail);
		}
		// return result
		return animeList;
	}

	/**
	 * This method build the URL Adress needed to call ANN API for retrieving an
	 * anime detail
	 *
	 * @param id
	 * @return
	 */
	private String getUrlWithParamForAnimeDetail(final Long id) {
		final StringBuilder urlWithParam = new StringBuilder();
		urlWithParam.append(ANN_LIST_DETAIL);// ,

		// Add start Parameter
		if (id != null) {
			urlWithParam.append(id.toString());
		}
		return urlWithParam.toString();
	}

	/**
	 * This method build the URL Adress needed to call ANN API for retrieving an
	 * anime detail
	 *
	 * @param id
	 * @return
	 */
	private String getUrlWithParamForAnimeListByName(final String name) {
		final StringBuilder urlWithParam = new StringBuilder();
		urlWithParam.append(ANN_LIST_DETAIL);// ,

		// Add start Parameter
		if (StringUtils.isNotBlank(name)) {
			urlWithParam.append("~").append(name);
		}
		return urlWithParam.toString();
	}

	private void slowQuery(final long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (final InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
