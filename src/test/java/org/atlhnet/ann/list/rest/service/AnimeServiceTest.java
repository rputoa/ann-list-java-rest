package org.atlhnet.ann.list.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.AnimeDao;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AnimeServiceTest {

	List<Anime> animes;
	Anime anime;

	@Mock
	private AnimeDao animeDao;

	@InjectMocks
	private AnimeService animeService;

	@Before
	public void init() {
		animes = getAnimesMock();
		anime = getAnimeMock();
	}

	@After
	public void destroy() {
		animes = null;
		anime = null;
	}

	/**
	 * Test getAnimeList with best case -> should return a List of Anime with 1
	 * member
	 */
	@Test
	public void getAnimeList() {
		// INIT
		Mockito.when(
				animeDao.findAnimeList(Mockito.anyInt(), Mockito.anyInt(),
						Mockito.anyString())).thenReturn(animes);
		// EXECUTE
		final List<Anime> animes = animeService.getAnimeList(1, 1, "");
		// VERIFY
		assertNotNull(animes);
		assertFalse(animes.isEmpty());

		Mockito.verify(animeDao).findAnimeList(Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyString());
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	/**
	 * Test getAnimeList with limit param = null -> should return empty List of
	 * Anime
	 */
	@Test
	public void getAnimeListWithNullLimit() {
		// INIT
		Mockito.when(
				animeDao.findAnimeList(Mockito.anyInt(), Mockito.anyInt(),
						Mockito.anyString())).thenReturn(animes);
		// EXECUTE
		final List<Anime> animes = animeService.getAnimeList(1, null, "");
		// VERIFY
		assertNotNull(animes);
		assertTrue(animes.isEmpty());

		Mockito.verifyZeroInteractions(animeDao);
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	/**
	 * Test getAnimeList with limit param = 0 -> should return empty list of
	 * Anime
	 */
	@Test
	public void getAnimeListWithLimitIsZero() {
		// INIT
		Mockito.when(
				animeDao.findAnimeList(Mockito.anyInt(), Mockito.anyInt(),
						Mockito.anyString())).thenReturn(animes);
		// EXECUTE
		final List<Anime> animes = animeService.getAnimeList(1, 0, "");
		// VERIFY
		assertNotNull(animes);
		assertTrue(animes.isEmpty());

		Mockito.verifyZeroInteractions(animeDao);
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	/**
	 * Test getAnimeDetail with best case -> should return the getAnimeMock
	 */
	@Test
	public void getAnimeDetail() {
		// INIT
		Mockito.when(animeDao.findAnimeDetail(Mockito.anyLong())).thenReturn(
				anime);
		// EXECUTE
		final Anime animeResult = animeService.getAnimeDetail(0L);
		// VERIFY
		assertNotNull(animeResult);
		assertEquals(anime.getId(), animeResult.getId());

		Mockito.verify(animeDao).findAnimeDetail(Mockito.anyLong());
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	/**
	 * Test getAnimeDetail with null id -> should return null
	 */
	@Test
	public void getAnimeDetailWithNullId() {
		// INIT
		Mockito.when(animeDao.findAnimeDetail(Mockito.anyLong())).thenReturn(
				anime);
		// EXECUTE
		final Anime animeResult = animeService.getAnimeDetail(null);
		// VERIFY
		assertNull(animeResult);

		Mockito.verifyZeroInteractions(animeDao);
		Mockito.verifyNoMoreInteractions(animeDao);
	}

	private List<Anime> getAnimesMock() {
		final List<Anime> animes = new ArrayList<Anime>();
		animes.add(getAnimeMock());
		return animes;
	}

	private Anime getAnimeMock() {
		final Anime anime = new Anime();
		anime.setId(1L);
		return anime;
	}

}
