package org.atlhnet.ann.list.rest.dao;

import java.util.List;

import org.atlhnet.ann.list.rest.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AnimeDao {

	@Autowired
	private AnimeListDao animeListDao;

	@Autowired
	private AnimeDetailDao animeDetailDao;

	public List<Anime> findAnimeList(final Integer start, final Integer limit,
			final String name) {

		List<Anime> animes = null;
		// No need to call API if you want 0 result
		if (limit != null && limit != 0L) {
			// Use list API to retrieve list
			animes = animeListDao.findList(start, limit, name);

			// if list is null call detail API
			if (animes.isEmpty()) {
				animes = animeDetailDao.findAnimeListByName(name);
			}
		}
		return animes;
	}

	@Cacheable(value = "getAnimeDetail", key = "#id")
	public Anime findAnimeDetail(final Long id) {
		return animeDetailDao.findAnimeDetail(id);
	}

}
