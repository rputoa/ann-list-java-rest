package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {

	private Long id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
