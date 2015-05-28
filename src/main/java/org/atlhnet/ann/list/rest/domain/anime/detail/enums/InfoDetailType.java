package org.atlhnet.ann.list.rest.domain.anime.detail.enums;

public enum InfoDetailType {

	VINTAGE("Vintage"), //
	GENRES("Genres"), //
	MAIN_TITLE("Main title");

	private String type;

	private InfoDetailType(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
