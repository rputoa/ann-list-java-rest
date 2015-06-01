package org.atlhnet.ann.list.rest.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.atlhnet.ann.list.rest.dao.domain.list.DaoAnimeList;
import org.atlhnet.ann.list.rest.dao.mapper.AnimeListMapper;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnimeListDao {

	// TODO Externalisze into .properties
	@Value("${ann.ws.rest.anime.list.url.core}")
	private final static String ANN_LIST_REPORT = "http://www.animenewsnetwork.com/encyclopedia/reports.xml?id=155&type=anime";
	@Value("${ann.ws.rest.anime.list.url.start}")
	private final static String URL_START_PARAM = "&nskip=";
	@Value("${ann.ws.rest.anime.list.url.limit}")
	private final static String URL_LIMIT_PARAM = "&nlist=";
	@Value("${ann.ws.rest.anime.list.url.name}")
	private final static String URL_NAME_PARAM = "&name=";

	@Autowired
	private AnimeNewsNetworkDao animeDaoSping;

	/** Retrieve list of anime from the retriever */
	public List<Anime> findList(final Integer start, final Integer limit,
			final String name) {

		final DaoAnimeList animeList = animeDaoSping.retrieveData(
				getUrlWithParamForAnimeList(start, limit, name),
				DaoAnimeList.class);
		final List<Anime> animes = AnimeListMapper.toAnimes(animeList);

		return animes;
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
