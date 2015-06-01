package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

@SuppressWarnings("serial")
public class AnimeCast implements Serializable {

	@XmlAttribute(name = "lang")
	private Language language;

	@XmlAttribute(name = "person")
	private Person person;

	@XmlAttribute(name = "role")
	private AnimeChara animeChara;

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(final Language language) {
		this.language = language;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(final Person person) {
		this.person = person;
	}

	public AnimeChara getAnimeChara() {
		return animeChara;
	}

	public void setAnimeChara(final AnimeChara animeChara) {
		this.animeChara = animeChara;
	}

}
