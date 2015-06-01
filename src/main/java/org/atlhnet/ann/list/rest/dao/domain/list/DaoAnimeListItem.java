package org.atlhnet.ann.list.rest.dao.domain.list;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represent an single line in reports from Anime News Network API with method
 * /list
 *
 * @author IPPON
 *
 */

@SuppressWarnings("serial")
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoAnimeListItem implements Serializable {

	private Long id;

	private Long gid;

	private String type;

	private String name;

	private String precision;

	private String vintage;

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

	public String getVintage() {
		return vintage;
	}

	public void setVintage(final String vintage) {
		this.vintage = vintage;
	}

}
