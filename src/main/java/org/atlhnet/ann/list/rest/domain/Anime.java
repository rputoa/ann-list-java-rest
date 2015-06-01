package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an Anime Description
 *
 * @author IPPON
 *
 */
@SuppressWarnings("serial")
public class Anime implements Serializable {

	private Long id;

	private Long gid;

	private AnimeType type;

	private String name;

	private String precision;

	// TODO Transform to date when rules is found
	private String date;

	private List<AnimeCast> casts;

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

	public AnimeType getType() {
		return type;
	}

	public void setType(final AnimeType type) {
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

	public List<AnimeCast> getCasts() {
		return casts;
	}

	public void setCasts(final List<AnimeCast> casts) {
		this.casts = casts;
	}

}
