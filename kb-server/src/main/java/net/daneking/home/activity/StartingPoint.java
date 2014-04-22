package net.daneking.home.activity;

import javax.ws.rs.core.MediaType;

import net.daneking.representation.Representation;

public class StartingPoint {
	public Representation<String> getInitialLinks(final String baseUri) {
		Representation<String> wrappedEntity = new Representation<String>("home");
		wrappedEntity.createSelfLink(baseUri);
		wrappedEntity.createLink("people", baseUri + "/people", MediaType.APPLICATION_JSON);
		return wrappedEntity;
	}

}
