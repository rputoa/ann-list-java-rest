package org.atlhnet.ann.list.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.AnimeDao;
import org.atlhnet.ann.list.rest.domain.AnimeDetail;
import org.atlhnet.ann.list.rest.domain.AnimeList;
import org.atlhnet.ann.list.rest.domain.Seiyuu;
import org.atlhnet.ann.list.rest.domain.anime.detail.AnimeCast;
import org.atlhnet.ann.list.rest.domain.anime.detail.Resume;
import org.atlhnet.ann.list.rest.domain.anime.detail.enums.Langage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AnimeServiceTest {

	AnimeList animeList;
	AnimeDetail animeDetail;

	@Mock
	private AnimeDao animeDao;

	@InjectMocks
	private AnimeService animeService;

	@Before
	public void init() {
		animeList = getAnimeListMock();
		animeDetail = getAnimeDetailMock();
	}

	@After
	public void destroy() {
		animeList = null;
		animeDetail = null;
	}

	/**
	 * This method test the return of getAnimeList from {@link AnimeService}
	 */
	@Test
	public void getAnimeList() {
		// INIT
		Mockito.when(
				animeDao.getAnimeList(Mockito.anyInt(), Mockito.any(),
						Mockito.anyString())).thenReturn(animeList);
		AnimeList animeListToTest = null;
		// EXECUTE
		animeListToTest = animeService.getAnimeList(0, 0, "");
		// VERIFY
		assertNotNull(animeListToTest);
		Mockito.verify(animeDao).getAnimeList(Mockito.anyInt(), Mockito.any(),
				Mockito.anyString());
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	@Test
	public void getAnimeDetail() {
		// INIT
		Mockito.when(animeDao.getAnimeDetail(Mockito.anyLong())).thenReturn(
				animeDetail);
		AnimeDetail animeDetailtoTest = null;
		// EXECUTE
		animeDetailtoTest = animeService.getAnimeDetail(0L);
		// VERIFY
		assertNotNull(animeDetailtoTest);
		assertNotNull(animeDetailtoTest.getResume());
		assertFalse(animeDetailtoTest.getResume().isEmpty());
		final Resume resume = animeDetailtoTest.getResume().get(0);
		assertNotNull(resume);
		assertNotNull(resume.getCasts());
		assertTrue(4 == resume.getCasts().size());

		Mockito.verify(animeDao).getAnimeDetail(Mockito.anyLong());
		Mockito.verifyNoMoreInteractions(animeDao);

	}

	@Test
	public void getAnimeDetailWithNullReturn() {
		// INIT
		Mockito.when(animeDao.getAnimeDetail(Mockito.anyLong())).thenReturn(
				null);
		AnimeDetail animeDetailtoTest = null;
		// EXECUTE
		animeDetailtoTest = animeService.getAnimeDetail(0L);
		// VERIFY
		assertNull(animeDetailtoTest);

		Mockito.verify(animeDao).getAnimeDetail(Mockito.anyLong());
		Mockito.verifyNoMoreInteractions(animeDao);

	}

	// MOCK

	private AnimeList getAnimeListMock() {
		final AnimeList animeList = new AnimeList();
		return animeList;
	}

	private AnimeDetail getAnimeDetailMock() {
		final AnimeDetail animeDetail = new AnimeDetail();
		animeDetail.setResume(getResumeListMock());
		return animeDetail;

	}

	private List<Resume> getResumeListMock() {
		final List<Resume> resumes = new ArrayList<Resume>();
		resumes.add(getResumeMock());
		return resumes;
	}

	private Resume getResumeMock() {
		final Resume resume = new Resume();
		resume.setId(1L);
		// Set Cast
		resume.setCasts(getAnimeCastsMock());
		return resume;
	}

	private List<AnimeCast> getAnimeCastsMock() {
		final List<AnimeCast> animeCasts = new ArrayList<AnimeCast>();
		animeCasts.add(createAnimeCastMock(1L, Langage.JA, "Suguha",
				"Ayana Taketatsu"));
		animeCasts.add(createAnimeCastMock(2L, Langage.JA, "Lisbeth",
				"Ayahi Takagaki"));
		animeCasts.add(createAnimeCastMock(3L, Langage.JA, "Asuna",
				"Haruka Tomatsu"));
		animeCasts.add(createAnimeCastMock(4L, Langage.JA, "Silica",
				"Rina Hidaka"));
		animeCasts.add(createAnimeCastMock(1L, Langage.EN, "Suguha",
				"Marie Lee"));
		return animeCasts;
	}

	private AnimeCast createAnimeCastMock(final Long gid, final Langage lang,
			final String role, final String name) {
		final AnimeCast animeCast = new AnimeCast();
		animeCast.setGid(gid);
		animeCast.setLang(lang);
		animeCast.setRole(role);
		final Seiyuu seiyuu = new Seiyuu();
		seiyuu.setName(name);
		animeCast.setSeiyuu(seiyuu);
		return animeCast;

	}

}
