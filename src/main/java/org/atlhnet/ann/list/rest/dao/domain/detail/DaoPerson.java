package org.atlhnet.ann.list.rest.dao.domain.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoPerson implements Serializable {

	@XmlAttribute(name = "id")
	private Long id;

	@XmlValue
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
