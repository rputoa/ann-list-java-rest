package org.atlhnet.ann.list.rest.domain.anime.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.atlhnet.ann.list.rest.domain.Seiyuu;
import org.atlhnet.ann.list.rest.domain.anime.detail.enums.Langage;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimeCast implements Serializable {

	@XmlAttribute
	private Long gid;

	@XmlAttribute
	private Langage lang;

	@XmlElement
	private String role;

	@XmlElement(name = "person")
	private Seiyuu seiyuu;

	public Long getGid() {
		return gid;
	}

	public void setGid(final Long gid) {
		this.gid = gid;
	}

	public Langage getLang() {
		return lang;
	}

	public void setLang(final Langage lang) {
		this.lang = lang;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public Seiyuu getSeiyuu() {
		return seiyuu;
	}

	public void setSeiyuu(final Seiyuu seiyuu) {
		this.seiyuu = seiyuu;
	}

}
