package org.atlhnet.ann.list.rest.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.domain.list.DaoAnimeList;
import org.atlhnet.ann.list.rest.dao.domain.list.DaoAnimeListItem;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.atlhnet.ann.list.rest.domain.AnimeType;

/**
 * Mapper class to convert from ANN API Object to Domain Object
 *
 * @author IPPON
 *
 */
public class AnimeListMapper {

	/**
	 * Convert an {@link DaoAnimeList} to a {@link List} of {@link Anime}
	 *
	 * @param animeList
	 * @return
	 */
	public static List<Anime> toAnimes(final DaoAnimeList animeList) {
		final List<Anime> animes = new ArrayList<Anime>();
		if (animeList != null && animeList.getAnimeListItems() != null) {
			for (final DaoAnimeListItem animeListItem : animeList
					.getAnimeListItems()) {
				final Anime anime = toAnime(animeListItem);
				animes.add(anime);
			}
		}

		return animes;

	}

	/**
	 * Convert an {@link DaoAnimeListItem} to a {@link Anime}
	 *
	 * @param animeListItem
	 * @return
	 */
	public static Anime toAnime(final DaoAnimeListItem animeListItem) {
		Anime anime = null;
		if (animeListItem != null) {
			anime = new Anime();
			anime.setId(animeListItem.getId());
			anime.setGid(animeListItem.getGid());
			anime.setName(animeListItem.getName());
			anime.setPrecision(animeListItem.getPrecision());
			anime.setDate(animeListItem.getVintage());
			anime.setType(AnimeType.valueOf(animeListItem.getType()));
		}
		return anime;
	}

}
