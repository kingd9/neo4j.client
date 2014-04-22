package net.daneking.home;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.daneking.representation.Link;
import net.daneking.representation.Representation;

import org.junit.Test;

import utils.TestSupport;

public class HomeResourceTest extends TestSupport<HomeResource> {

	@Test
	@SuppressWarnings("unchecked")
	public void shouldHaveLinks() {
		final Response response = getItem(Status.OK.getStatusCode());
		Representation<String> homeRepresentation = response.readEntity(Representation.class);
		Link selfLink = homeRepresentation.getLinkByName("self");
		assertEquals(MediaType.APPLICATION_JSON, selfLink.getMediaType());
		assertEquals("self", selfLink.getName());
		assertEquals("http://localhost:9998/", selfLink.getUri());
	}

	private Response getItem(final int status) {
		final Response response = getResource().request(MediaType.APPLICATION_JSON).get(Response.class);
		assertEquals(status, response.getStatus());
		return response;
	}

	protected WebTarget getResource() {
		return target("/");
	}

}
