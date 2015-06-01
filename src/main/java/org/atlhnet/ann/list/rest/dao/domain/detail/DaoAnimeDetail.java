package org.atlhnet.ann.list.rest.dao.domain.detail;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoAnimeDetail implements Serializable {

	@XmlAttribute
	private Long id;

	@XmlAttribute
	private Long gid;

	@XmlAttribute
	private String type;

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String precision;

	@XmlElement(name = "info")
	private List<DaoInfo> infos;

	@XmlElement(name = "cast")
	private List<DaoCast> casts;

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

	public List<DaoInfo> getInfos() {
		return infos;
	}

	public void setInfos(final List<DaoInfo> infos) {
		this.infos = infos;
	}

	public List<DaoCast> getCasts() {
		return casts;
	}

	public void setCasts(final List<DaoCast> casts) {
		this.casts = casts;
	}

}
