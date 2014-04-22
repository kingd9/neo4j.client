package net.daneking.representation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class Link {
	public Link() {
	}

	public Link(final String name, final String uri, final String mediaType) {
		this.name = name;
		this.uri = uri;
		this.mediaType = mediaType;
	}

	@XmlAttribute(name = "rel")
	private String name;

	private String uri;

	private String mediaType;

	@JsonProperty("rel")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(final String uri) {
		this.uri = uri;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(final String mediaType) {
		this.mediaType = mediaType;
	}

}
