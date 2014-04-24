package net.daneking.document;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.daneking.document.domain.Document;

import org.junit.Test;

import utils.TestSupport;

public class DocumentResourceIntegrationTest extends TestSupport<DocumentResource> {

	@Test
	public void shouldReturnA404WhenItemIsNotFound() {
		final Response response = getItem("345");
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}

	@Test
	public void shouldReturnA200WhenItemIsFound() {
		Document document = new Document(20);
		document.setName("test");
		document.setType("note");

		final Response response = getItem("20");
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}

	private Response getItem(final String id) {
		final Response response = documentResource().path(id).request(MediaType.APPLICATION_JSON).get(Response.class);
		return response;
	}

	@Test
	public void shouldReturnA204WhenItemIsSaved() {
		final Response response = putItem(new Document(2));
		assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());

	}

	private Response putItem(final Document information) {
		Integer id = Integer.valueOf(20);
		Document entity = new Document(id);
		entity.setName("test");
		entity.setType("TestType");
		final Response response = documentResource().path(id.toString()).request().put(Entity.json(entity));
		return response;
	}

	protected WebTarget documentResource() {
		return target("documents");
	}

}
