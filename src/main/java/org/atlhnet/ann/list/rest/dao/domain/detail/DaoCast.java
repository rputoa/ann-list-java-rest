package org.atlhnet.ann.list.rest.dao.domain.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoCast implements Serializable {

	@XmlAttribute(name = "lang")
	private String lang;

	@XmlAttribute(name = "gid")
	private Long gid;

	@XmlElement(name = "role")
	private String role;

	@XmlElement(name = "person")
	private DaoPerson person;

	public String getLang() {
		return lang;
	}

	public void setLang(final String lang) {
		this.lang = lang;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public DaoPerson getPerson() {
		return person;
	}

	public void setPerson(final DaoPerson person) {
		this.person = person;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(final Long gid) {
		this.gid = gid;
	}

}
