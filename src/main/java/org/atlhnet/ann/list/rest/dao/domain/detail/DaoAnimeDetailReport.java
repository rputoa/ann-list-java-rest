package org.atlhnet.ann.list.rest.dao.domain.detail;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "ann")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoAnimeDetailReport implements Serializable {

	@XmlElement(name = "anime")
	private List<DaoAnimeDetail> animes;

	public List<DaoAnimeDetail> getAnimes() {
		return animes;
	}

	public void setAnimes(final List<DaoAnimeDetail> animes) {
		this.animes = animes;
	}

}
