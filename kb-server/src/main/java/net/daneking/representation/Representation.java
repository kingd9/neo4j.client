package net.daneking.representation;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Representation<T> {
	public Representation() {
		this.entity = null;
		createLink("self", "/items", MediaType.APPLICATION_JSON);
	}

	public Representation(final T entity) {
		this.entity = entity;
	}

	@XmlElement
	private final T entity;

	public T getEntity() {
		return this.entity;
	}

	@XmlElement
	private final List<Link> links = new ArrayList<Link>();

	public List<Link> getLinks() {
		return links;
	}

	public void createSelfLink(final String uri) {
		links.add(new Link("self", uri, MediaType.APPLICATION_JSON));
	}

	public void createLink(final String name, final String uri, final String mediaType) {
		links.add(new Link(name, uri, mediaType));
	}

	public Link getLinkByName(final String uriName) {
		for (Link link : links) {
			if ((link.getName().compareToIgnoreCase(uriName)) == 0) {
				return link;
			}
		}
		return null;
	}
}
