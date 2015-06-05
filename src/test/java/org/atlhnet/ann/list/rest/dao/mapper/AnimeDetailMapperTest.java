package org.atlhnet.ann.list.rest.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.domain.detail.*;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.atlhnet.ann.list.rest.domain.AnimeType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("unused")
public class AnimeDetailMapperTest {

	private final String ROLE_ASUNA = "Asuna YUUKI";
	private final String ROLE_SUGU = "Suguha KIRIGAYA";
	private final String ROLE_KIRITO = "Kazuto KIRIGAYA";

	private final String PERSON_HARU = "Haruka TOMATSU";
	private final String PERSON_AYA = "Ayana TAKETATSU";
	private final String PERSON_YOSHI = "Yoshitsugu MATSUOKA";

	private final String LANG_JA = "JA";
	private final String ANIME_MOCK_1_NAME = "Sword Art Online";
	private final String ANIME_MOCK_1_DATE = "2015-01-01";
	private final Long ANIME_MOCK_1_ID = 1L;
	private final Long ANIME_MOCK_1_GID = 1L;
	private final String ANIME_MOCK_1_PRECISION = "TV";
	private final String ANIME_MOCK_2_NAME = "Sword Art Online : Hollow Fragment";
	private final String ANIME_MOCK_3_NAME = " Sword Art Online : Lost Song";
	private DaoAnimeDetailReport daoAnimeDetailReport;
	private DaoAnimeDetail animeDetailMock;

	@Before
	public void init() {
		daoAnimeDetailReport = getReportMock();
		animeDetailMock = getAnimeDetailMock1();
	}

	@After
	public void destroy() {
		daoAnimeDetailReport = null;
		animeDetailMock = null;
	}

	@Test
	public void toAnimeForList() {
		// EXECUTE
		final Anime anime = AnimeDetailMapper.toAnimeForList(animeDetailMock);
		// VERIFY
		assertNotNull(anime);
		assertEquals(animeDetailMock.getId(), anime.getId());
		assertEquals(animeDetailMock.getGid(), anime.getGid());
		assertEquals(animeDetailMock.getName(), anime.getName());
		assertEquals(animeDetailMock.getPrecision(), anime.getPrecision());
		assertEquals(AnimeType.convert(animeDetailMock.getType()),
				anime.getType());
		assertEquals(ANIME_MOCK_1_DATE, anime.getDate());

	}

	@Test
	public void toAnimeForListWithNullInput() {
		// EXECUTE
		final Anime anime = AnimeDetailMapper.toAnimeForList(null);
		// VERIFY
		assertNull(anime);
	}

	@Test
	public void toAnimeForListWithNullAnimeType() {
		// INIT
		animeDetailMock.setType(null);
		// EXECUTE
		final Anime anime = AnimeDetailMapper.toAnimeForList(animeDetailMock);
		// VERIFY
		assertNotNull(anime);
		assertEquals(animeDetailMock.getId(), anime.getId());
		assertEquals(animeDetailMock.getGid(), anime.getGid());
		assertEquals(animeDetailMock.getName(), anime.getName());
		assertEquals(animeDetailMock.getPrecision(), anime.getPrecision());
		assertEquals(AnimeType.UNDEFINED, anime.getType());
		assertEquals(ANIME_MOCK_1_DATE, anime.getDate());

	}

	@Test
	public void toAnimes() {
		// EXECUTE
		List<Anime> animes = AnimeDetailMapper.toAnimes(daoAnimeDetailReport);
		// VERIFY
		assertNotNull(animes);
		assertTrue(3 == animes.size());
	}

	@Test
	public void toAnimesWithNullInput() {
		// EXECUTE
		List<Anime> animes = AnimeDetailMapper.toAnimes(null);
		// VERIFY
		assertNotNull(animes);
		assertTrue(animes.isEmpty());
	}

	@Test
	public void toAnime() {
		// EXECUTE
		Anime anime = AnimeDetailMapper.toAnime(daoAnimeDetailReport);
		// VERIFY
		assertNotNull(anime);


	}

	// MOCK

	private DaoAnimeDetailReport getReportMock() {
		DaoAnimeDetailReport report = new DaoAnimeDetailReport();
		report.setAnimes(getAnimeDetailsMock());
		return report;
	}

	private List<DaoAnimeDetail> getAnimeDetailsMock() {
		final List<DaoAnimeDetail> list = new ArrayList<DaoAnimeDetail>();
		list.add(getAnimeDetailMock1());
		list.add(getAnimeDetailMock2());
		list.add(getAnimeDetailMock3());
		return list;
	}

	private DaoAnimeDetail getAnimeDetailMock1() {
		final DaoAnimeDetail mock = new DaoAnimeDetail();
		mock.setCasts(getDaoCastsMock());
		mock.setId(ANIME_MOCK_1_ID);
		mock.setId(ANIME_MOCK_1_GID);
		mock.setName(ANIME_MOCK_1_NAME);
		mock.setType("TV");
		mock.setPrecision(ANIME_MOCK_1_PRECISION);
		// create Info
		final DaoInfo daoInfo1 = new DaoInfo();
		daoInfo1.setValue(ANIME_MOCK_1_DATE);
		daoInfo1.setType("vintage");

		final DaoInfo daoInfo2 = new DaoInfo();
		daoInfo2.setType("other");
		daoInfo2.setValue("OTHER");

		final List<DaoInfo> infos = new ArrayList<DaoInfo>();
		infos.add(daoInfo1);
		infos.add(daoInfo2);
		mock.setInfos(infos);

		return mock;
	}

	private DaoAnimeDetail getAnimeDetailMock2() {
		final DaoAnimeDetail mock = new DaoAnimeDetail();
		mock.setId(2L);
		mock.setName(ANIME_MOCK_2_NAME);

		// create Type
		mock.setType("OTHER");
		return mock;
	}

	private DaoAnimeDetail getAnimeDetailMock3() {
		final DaoAnimeDetail mock = new DaoAnimeDetail();
		mock.setId(3L);
		mock.setName(ANIME_MOCK_3_NAME);

		// create Type
		mock.setType("OTHER");
		return mock;
	}

	private List<DaoCast> getDaoCastsMock() {
		final List<DaoCast> casts = new ArrayList<DaoCast>();
		casts.add(createDaoCastMock(PERSON_AYA, ROLE_SUGU, LANG_JA));
		casts.add(createDaoCastMock(PERSON_HARU, ROLE_ASUNA, LANG_JA));
		casts.add(createDaoCastMock(PERSON_YOSHI, ROLE_KIRITO, LANG_JA));
		return casts;
	}

	private DaoCast createDaoCastMock(final String name, final String role,
			final String lang) {
		final DaoCast cast = new DaoCast();
		cast.setRole(role);
		cast.setPerson(createDaoPersonMock(name));
		cast.setLang(lang);
		return cast;
	}

	private DaoPerson createDaoPersonMock(final String name) {
		final DaoPerson person = new DaoPerson();
		person.setValue(name);
		return person;
	}
}
