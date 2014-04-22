package net.daneking.home.activity;

import javax.ws.rs.core.MediaType;

import net.daneking.representation.Representation;

public class StartingPoint {

	private static final String DOCUMENT_PATH = "document";

	public Representation<String> getInitialLinks(final String baseUri) {
		Representation<String> wrappedEntity = new Representation<String>("home");
		wrappedEntity.createSelfLink(baseUri);
		wrappedEntity.createLink(DOCUMENT_PATH, createPath(baseUri, DOCUMENT_PATH), MediaType.APPLICATION_JSON);
		return wrappedEntity;
	}

	private String createPath(final String baseUri, final String path) {
		return baseUri + "/" + path;
	}

}
