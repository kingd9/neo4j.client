package net.daneking.document.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement()
public class Document {
	protected static final Logger _logger = LoggerFactory.getLogger(Document.class);

	public Document() {
	}

	public Document(final String identifier) {
		this.identifier = identifier;
	}

	private String identifier;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

}
