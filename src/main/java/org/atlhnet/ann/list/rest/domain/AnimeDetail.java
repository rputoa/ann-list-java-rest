package org.atlhnet.ann.list.rest.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.atlhnet.ann.list.rest.domain.anime.detail.Resume;

/**
 * Represent an Anime Detail
 *
 * @author IPPON
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "ann")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimeDetail implements Serializable {

	@XmlElement(name = "anime")
	private List<Resume> Resume;

	public List<Resume> getResume() {
		return Resume;
	}

	public void setResume(final List<Resume> resume) {
		Resume = resume;
	}

}
