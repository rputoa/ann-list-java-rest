package org.atlhnet.ann.list.rest.domain.anime.detail;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class EpisodeDetail implements Serializable {

	@XmlAttribute
	private Long num;

	@XmlElement(name = "title")
	private List<EpisodeTitle> titles;

	public Long getNum() {
		return num;
	}

	public void setNum(final Long num) {
		this.num = num;
	}

	public List<EpisodeTitle> getTitles() {
		return titles;
	}

	public void setTitles(final List<EpisodeTitle> titles) {
		this.titles = titles;
	}

}
