package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AnimeChara implements Serializable {

	private Long id;

	private String name;

	private String desc;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
