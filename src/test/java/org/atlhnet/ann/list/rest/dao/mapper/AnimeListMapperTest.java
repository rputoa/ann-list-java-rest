package org.atlhnet.ann.list.rest.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.atlhnet.ann.list.rest.dao.domain.list.DaoAnimeList;
import org.atlhnet.ann.list.rest.dao.domain.list.DaoAnimeListItem;
import org.atlhnet.ann.list.rest.domain.Anime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnimeListMapperTest {

	private final Long DAOALI_ID = 1L;
	private final Long DAOALI_GID = 1L;
	private final String DAOALI_NAME = "SAO";
	private final String DAOALI_PRECISION = "Precision";
	private final String DAOALI_TYPE = "TV";
	private final String DAOALI_VINTAGE = "2015";

	private DaoAnimeList daoAnimeList;

	@Before
	public void init() {
		daoAnimeList = getDaoAnimeListMock();
	}

	@After
	public void destroy() {
		daoAnimeList = null;
	}

	/**
	 * Should return populated list of anime
	 */
	@Test
	public void toAnimes() {
		// INIT

		// EXECUTE
		final List<Anime> animes = AnimeListMapper.toAnimes(daoAnimeList);
		// VERIFY
		assertNotNull(animes);
		assertFalse(animes.isEmpty());
		assertEquals(1, animes.size());
	}

	/**
	 * Should return empty list of anime
	 */
	@Test
	public void toAnimesWithNullInput() {
		// INIT

		// EXECUTE
		final List<Anime> animes = AnimeListMapper.toAnimes(null);
		// VERIFY
		assertNotNull(animes);
		assertTrue(animes.isEmpty());
	}

	// Mock
	private DaoAnimeList getDaoAnimeListMock() {
		final DaoAnimeList daoAL = new DaoAnimeList();
		daoAL.setAnimeListItems(getDaoAnimeListItemsMock());
		return daoAL;
	}

	private List<DaoAnimeListItem> getDaoAnimeListItemsMock() {
		final List<DaoAnimeListItem> daoAnimeListItems = new ArrayList<DaoAnimeListItem>();
		daoAnimeListItems.add(getDaoAnimeListItemMock());
		return daoAnimeListItems;
	}

	private DaoAnimeListItem getDaoAnimeListItemMock() {
		final DaoAnimeListItem daoAnimeList = new DaoAnimeListItem();
		daoAnimeList.setId(DAOALI_ID);
		daoAnimeList.setGid(DAOALI_GID);
		daoAnimeList.setName(DAOALI_NAME);
		daoAnimeList.setPrecision(DAOALI_PRECISION);
		daoAnimeList.setType(DAOALI_TYPE);
		daoAnimeList.setVintage(DAOALI_VINTAGE);

		return daoAnimeList;
	}

}
