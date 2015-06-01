package org.atlhnet.ann.list.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.AnimeDao;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

	@Autowired
	private AnimeDao animeDao;

	/**
	 * Return an {@link List} of {@link Anime}
	 *
	 * @param start
	 * @param limit
	 * @param name
	 * @return
	 */
	public List<Anime> getAnimeList(final Integer start, final Integer limit,
			final String name) {
		List<Anime> animes = new ArrayList<Anime>();
		if (limit != null && limit != 0) {
			animes = animeDao.findAnimeList(start, limit, name);
		}
		return animes;
	}

	/**
	 * Return an {@link Anime} from an Id
	 *
	 * @param id
	 * @return
	 */
	public Anime getAnimeDetail(final Long id) {
		Anime anime = null;
		if (id != null) {
			// Retrieve animeDetail from Dao
			anime = animeDao.findAnimeDetail(id);
		}

		return anime;
	}

}
