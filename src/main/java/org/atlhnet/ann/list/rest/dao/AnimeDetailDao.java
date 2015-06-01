package org.atlhnet.ann.list.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoAnimeDetailReport;
import org.atlhnet.ann.list.rest.dao.mapper.AnimeDetailMapper;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AnimeDetailDao {

	@Value("${ann.ws.rest.anime.detail.url.core}")
	private String ANN_LIST_DETAIL;

	@Autowired
	private AnimeNewsNetworkDao animeNewsNetworkDao;

	@Cacheable(value = "getAnimeDetail", key = "#id")
	public Anime findAnimeDetail(final Long id) {
		Anime anime = null;
		if (id != null) {
			final DaoAnimeDetailReport animeDetailReport = animeNewsNetworkDao
					.retrieveData(getUrlWithParamForAnimeDetail(id),
							DaoAnimeDetailReport.class);

			anime = AnimeDetailMapper.toAnime(animeDetailReport);
		}
		return anime;
	}

	@Cacheable(value = "getAnimeDetail", key = "#name")
	public List<Anime> findAnimeListByName(final String name) {
		List<Anime> animes = new ArrayList<Anime>();

		if (StringUtils.isNotBlank(name)) {
			// Retrieve list of anime by name with full detail
			final DaoAnimeDetailReport animeDetailReport = animeNewsNetworkDao
					.retrieveData(getUrlWithParamForAnimeListByName(name),
							DaoAnimeDetailReport.class);
			// Convert into AnimeList
			animes = AnimeDetailMapper.toAnimes(animeDetailReport);
		}
		// return result
		return animes;
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
}
