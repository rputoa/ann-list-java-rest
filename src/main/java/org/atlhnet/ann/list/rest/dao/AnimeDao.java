package org.atlhnet.ann.list.rest.dao;

import org.atlhnet.ann.list.rest.domain.AnimeDetail;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AnimeDao {

	@Autowired
	private AnimeListDao animeListDao;

	@Autowired
	private AnimeDetailDao animeDetailDao;

	public AnimeList getAnimeList(final Integer start, final Integer limit,
			final String name) {

		AnimeList animeList = null;
		// No need to call API if you want 0 result
		if (limit != null && limit != 0L) {
			// Use list API to retrieve list
			animeList = animeListDao.getList(start, limit, name);

			// if list is null call detail API
			if (animeList == null
					|| animeList != null
					&& (animeList.getAnimes() == null || animeList.getAnimes()
					.isEmpty())) {
				animeList = animeDetailDao.getAnimeListByName(name);
			}
		}
		return animeList;
	}

	@Cacheable(value = "getAnimeDetail", key = "#id")
	public AnimeDetail getAnimeDetail(final Long id) {
		return animeDetailDao.getAnimeDetail(id);
	}

}
