package org.atlhnet.ann.list.rest.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.domain.AnimeDetail;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.atlhnet.ann.list.rest.domain.AnimeListItem;
import org.atlhnet.ann.list.rest.domain.anime.detail.InfoDetail;
import org.atlhnet.ann.list.rest.domain.anime.detail.Resume;
import org.atlhnet.ann.list.rest.domain.anime.detail.enums.InfoDetailType;

public class AnimeListMapper {

	public static AnimeList mapFromAnimeDetail(final AnimeDetail animeDetail) {
		AnimeList animeList = null;
		if (animeDetail != null && animeDetail.getResume() != null) {
			animeList = new AnimeList();
			animeList.setAnimes(toAnimeListItems(animeDetail.getResume()));

		}
		return animeList;
	}

	/**
	 * Convert a {@link List} of {@link Resume} into a {@link List} of
	 * {@link AnimeListItem}
	 *
	 * @param resume
	 * @return
	 */
	private static List<AnimeListItem> toAnimeListItems(
			final List<Resume> resumes) {
		final List<AnimeListItem> animeListItems = new ArrayList<AnimeListItem>();
		if (resumes != null) {
			for (final Resume resume : resumes) {
				final AnimeListItem animeListItem = toAnimeListItem(resume);
				animeListItems.add(animeListItem);
			}
		}
		return animeListItems;
	}

	/**
	 * Convert a {@link Resume} of an anime into a {@link AnimeListItem}
	 *
	 * @param resume
	 * @return
	 */
	private static AnimeListItem toAnimeListItem(final Resume resume) {
		AnimeListItem animeListItem = null;
		if (resume != null) {
			animeListItem = new AnimeListItem();
			animeListItem.setName(resume.getName());
			animeListItem.setGid(resume.getGid());
			animeListItem.setId(resume.getId());
			animeListItem.setPrecision(resume.getPrecision());
			animeListItem.setType(resume.getType());
			animeListItem.setDate(getVintageFromResume(resume));
		}
		return animeListItem;
	}

	/**
	 * Return the date of the anime {@link Resume} Search in {@link Resume}
	 * {@link List} {@link InfoDetail} for the {@link InfoDetail} with the
	 * attribute Vintage and returns it
	 *
	 * @param resume
	 * @return
	 */
	private static String getVintageFromResume(final Resume resume) {
		String vintage = "";
		if (resume != null && resume.getInfos() != null) {
			for (final InfoDetail info : resume.getInfos()) {
				if (InfoDetailType.VINTAGE.getType().equals(info.getType())) {
					vintage = info.getValue();
					break;
				}
			}
		}
		return vintage;
	}
}
