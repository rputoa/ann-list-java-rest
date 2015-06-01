package org.atlhnet.ann.list.rest.dao.domain.detail;

import org.apache.commons.lang3.StringUtils;

public enum DaoInfoType {

	VINTAGE("vintage"), //
	UNDEFINED("undefined");// ;

	private String type;

	private DaoInfoType(final String type) {
		this.type = type;
	}

	public static DaoInfoType convert(final String input) {
		DaoInfoType infoType = UNDEFINED;
		if (StringUtils.isNotBlank(input)) {
			for (final DaoInfoType type : values()) {
				if (type.getType().equalsIgnoreCase(input)) {
					infoType = type;
				}
			}
		}
		return infoType;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

}
