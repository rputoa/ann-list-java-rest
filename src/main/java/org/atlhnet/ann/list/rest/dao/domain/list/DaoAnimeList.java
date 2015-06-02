package org.atlhnet.ann.list.rest.dao.domain.list;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represent an report retrieved from anime news network API with method /list
 *
 * @author IPPON
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoAnimeList implements Serializable {

	@XmlAttribute(name = "skipped")
	private Long skipped;

	@XmlAttribute(name = "listed")
	private Long listed;

	@XmlElement(name = "item")
	List<DaoAnimeListItem> animeListItems;

	public List<DaoAnimeListItem> getAnimeListItems() {
		return animeListItems;
	}

	public void setAnimeListItems(final List<DaoAnimeListItem> animeListItems) {
		this.animeListItems = animeListItems;
	}

}
