package org.atlhnet.ann.list.rest.domain.anime.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import org.atlhnet.ann.list.rest.domain.anime.detail.enums.Langage;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoDetail implements Serializable {

	@XmlAttribute
	private Long gid;

	@XmlAttribute
	private String type;

	@XmlAttribute
	private Langage lang;

	@XmlValue
	private String value;

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

	public Langage getLang() {
		return lang;
	}

	public void setLang(final Langage lang) {
		this.lang = lang;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
