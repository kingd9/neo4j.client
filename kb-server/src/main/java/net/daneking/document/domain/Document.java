package net.daneking.document.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement()
public class Document {
	protected static final Logger _logger = LoggerFactory.getLogger(Document.class);
	private Integer id;

	private String name;

	private String type;

	public Document(final Integer id) {
		this.id = id;
	}

	public Document() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

}
