package org.atlhnet.ann.list.rest.rest;

import java.util.List;

import org.atlhnet.ann.list.rest.domain.Anime;
import org.atlhnet.ann.list.rest.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeRestController {

	@Autowired
	private AnimeService animeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Anime> getAnimeList(
			@RequestParam(value = "start", required = false) final Integer start,
			@RequestParam(value = "limit", required = false) final Integer limit,
			@RequestParam(value = "name", required = false) final String name) {

		return animeService.getAnimeList(start, limit, name);
	}

	@RequestMapping(value = "/anime/{id}", method = RequestMethod.GET, produces = "application/json")
	public Anime getAnimeDetail(@PathVariable(value = "id") final Long id) {
		return animeService.getAnimeDetail(id);
	}
}
