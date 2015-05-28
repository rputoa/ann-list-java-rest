package org.atlhnet.ann.list.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.AnimeDao;
import org.atlhnet.ann.list.rest.domain.AnimeDetail;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.atlhnet.ann.list.rest.domain.Seiyuu;
import org.atlhnet.ann.list.rest.domain.anime.detail.AnimeCast;
import org.atlhnet.ann.list.rest.domain.anime.detail.enums.Langage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

	@Autowired
	private AnimeDao animeDao;

	public AnimeList getAnimeList(final Integer start, final Integer limit,
			final String name) {
		return animeDao.getAnimeList(start, limit, name);
	}

	/**
	 * This method return the detail of {@link AnimeDetail} wit id = id If there
	 * is a list of {@link Seiyuu}, it filters all non japanese one
	 *
	 * @param id
	 * @return
	 */
	public AnimeDetail getAnimeDetail(final Long id) {
		AnimeDetail animeDetail = null;
		if (id != null) {
			// Retrieve animeDetail from Dao
			animeDetail = animeDao.getAnimeDetail(id);

			// Filter animecast List if it is not japanese
			if (animeDetail != null && animeDetail.getResume() != null
					&& animeDetail.getResume().get(0) != null
					&& animeDetail.getResume().get(0).getCasts() != null) {
				animeDetail
						.getResume()
						.get(0)
						.setCasts(
								getAnimeCastFilteredByLang(animeDetail
										.getResume().get(0).getCasts(),
										Langage.JA));
			}
		}

		return animeDetail;
	}

	/**
	 * This method filter the list of {@link AnimeCast} in order to only show
	 * cast of a certain {@link Langage}
	 *
	 * @param casts
	 * @param lang
	 */
	private List<AnimeCast> getAnimeCastFilteredByLang(
			final List<AnimeCast> casts, final Langage lang) {
		final List<AnimeCast> animeCasts = new ArrayList<AnimeCast>();
		if (casts != null && lang != null) {
			for (final AnimeCast cast : casts) {
				if (cast.getSeiyuu() != null && cast.getLang() == lang) {
					animeCasts.add(cast);
				}
			}
		}
		return animeCasts;
	}

}
