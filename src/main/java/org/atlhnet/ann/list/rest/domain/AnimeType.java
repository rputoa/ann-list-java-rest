package org.atlhnet.ann.list.rest.domain;

import org.apache.commons.lang3.StringUtils;

public enum AnimeType {

	OAV, //
	SPECIAL, //
	MANGA, //
	ONA, //
	MOVIE, //
	TV, //
	UNDEFINED;

	public static AnimeType convert(final String input) {
		AnimeType animeType = UNDEFINED;
		if (StringUtils.isNotBlank(input)) {
			for (final AnimeType type : values()) {
				if (type.name().equalsIgnoreCase(input)) {
					animeType = type;
				}
			}
		}
		return animeType;
	}

}
