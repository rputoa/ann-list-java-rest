package org.atlhnet.ann.list.rest.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoAnimeDetail;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoAnimeDetailReport;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoCast;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoInfo;
import org.atlhnet.ann.list.rest.dao.domain.detail.DaoInfoType;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.atlhnet.ann.list.rest.domain.AnimeCast;
import org.atlhnet.ann.list.rest.domain.AnimeChara;
import org.atlhnet.ann.list.rest.domain.AnimeType;
import org.atlhnet.ann.list.rest.domain.Language;
import org.atlhnet.ann.list.rest.domain.Person;

public class AnimeDetailMapper {

	/**
	 * Convert an {@link DaoAnimeDetailReport} into a {@link List} of
	 * {@link Anime}
	 *
	 * @param report
	 * @return
	 */
	public static List<Anime> toAnimes(final DaoAnimeDetailReport report) {
		final List<Anime> animes = new ArrayList<Anime>();
		if (report != null && report.getAnimes() != null) {
			for (final DaoAnimeDetail detail : report.getAnimes()) {
				final Anime anime = toAnimeForList(detail);
				animes.add(anime);
			}
		}
		return animes;
	}

	/**
	 * Convert an {@link DaoAnimeDetail} into an {@link Anime} with only the
	 * necessary information for list display
	 *
	 * @param detail
	 * @return
	 */
	public static Anime toAnimeForList(final DaoAnimeDetail detail) {
		Anime anime = null;
		if (detail != null) {
			anime = new Anime();
			anime.setId(detail.getId());
			anime.setGid(detail.getGid());
			anime.setName(detail.getName());
			anime.setPrecision(detail.getPrecision());
			anime.setType(AnimeType.convert(detail.getType()));
			// find anime Vintage
			anime.setDate(getAnimeDetailVintage(detail.getInfos()));
		}

		return anime;
	}

	/**
	 * Convert an {@link DaoAnimeDetail} into an {@link Anime} with all
	 * information
	 *
	 * @param detail
	 * @return
	 */
	public static Anime toAnime(final DaoAnimeDetailReport detail) {
		Anime anime = null;
		if (detail != null && detail.getAnimes() != null
				&& !detail.getAnimes().isEmpty()) {

			final DaoAnimeDetail animeDetail = detail.getAnimes().get(0);

			anime = new Anime();
			anime.setId(animeDetail.getId());
			anime.setGid(animeDetail.getGid());
			anime.setName(animeDetail.getName());
			anime.setPrecision(animeDetail.getPrecision());
			anime.setType(AnimeType.convert(animeDetail.getType()));
			// find anime Vintage
			anime.setDate(getAnimeDetailVintage(animeDetail.getInfos()));
			// Add Seiyuu List
			anime.setCasts(toAnimeCasts(animeDetail.getCasts()));
		}
		return anime;
	}

	/**
	 * Find the anime diffusion date
	 *
	 * @param infos
	 * @return
	 */
	private static String getAnimeDetailVintage(final List<DaoInfo> infos) {
		String vintage = "";
		if (infos != null) {
			for (final DaoInfo info : infos) {
				if (DaoInfoType.VINTAGE.equals(DaoInfoType.convert(info
						.getType()))) {
					vintage = info.getValue();
					break;
				}
			}
		}
		return vintage;
	}

	private static List<AnimeCast> toAnimeCasts(final List<DaoCast> casts) {
		final List<AnimeCast> animeCasts = new ArrayList<AnimeCast>();
		if (casts != null) {
			for (final DaoCast daoCast : casts) {
				final AnimeCast animeCast = toAnimeCast(daoCast);
				animeCasts.add(animeCast);
			}
		}
		return animeCasts;
	}

	private static AnimeCast toAnimeCast(final DaoCast daoCast) {
		AnimeCast animeCast = null;
		if (daoCast != null && StringUtils.isNotBlank(daoCast.getRole())
				&& daoCast.getPerson() != null) {
			animeCast = new AnimeCast();
			// To Role
			final AnimeChara animeChara = new AnimeChara();
			animeChara.setName(daoCast.getRole());
			animeCast.setAnimeChara(animeChara);

			// To Person
			final Person person = new Person();
			person.setId(daoCast.getPerson().getId());
			person.setName(daoCast.getPerson().getValue());
			animeCast.setPerson(person);

			// To Lang
			animeCast.setLanguage(Language.convert(daoCast.getLang()));

		}
		return animeCast;
	}

}
