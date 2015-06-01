package org.atlhnet.ann.list.rest.domain;

import org.apache.commons.lang3.StringUtils;

public enum Language {

	EN, //
	JA, //
	RU, //
	FR, //
	UNDEFINED;

	public static Language convert(final String input) {
		Language lang = UNDEFINED;
		if (StringUtils.isNotBlank(input)) {
			for (final Language type : values()) {
				if (type.name().equalsIgnoreCase(input)) {
					lang = type;
				}
			}
		}
		return lang;
	}
}
