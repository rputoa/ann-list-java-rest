package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimeListItem implements Serializable {

	private Long id;

	private Long gid;

	private String type;

	private String name;

	private String precision;

	@XmlElement(name = "vintage")
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(final Long gid) {
		this.gid = gid;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(final String precision) {
		this.precision = precision;
	}

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

}
