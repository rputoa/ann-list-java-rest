package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimeList implements Serializable {

	@XmlElement(name = "item")
	private List<AnimeListItem> animes;

	public List<AnimeListItem> getAnimes() {
		return animes;
	}

	public void setAnimes(final List<AnimeListItem> animes) {
		this.animes = animes;
	}

}
