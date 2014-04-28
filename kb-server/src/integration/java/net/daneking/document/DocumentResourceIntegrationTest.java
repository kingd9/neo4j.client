package net.daneking.document;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.daneking.document.domain.Document;

import org.junit.Before;
import org.junit.Test;

import utils.TestSupport;

public class DocumentResourceIntegrationTest extends TestSupport<DocumentResource> {
	private static final String INITIAL_ITEM_ID = "20";

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		addInitialItem();
	}

	private void addInitialItem() {
		Document document = new Document(INITIAL_ITEM_ID);
		final Response response = putItem(document);
	}

	@Test
	public void shouldReturnA404WhenItemIsNotFound() {
		final Response response = getItem("345");
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}

	@Test
	public void shouldReturnA200WhenItemIsFound() {

		final Response response = getItem(INITIAL_ITEM_ID.toString());
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}

	private Response getItem(final String id) {
		final Response response = documentResource().path(id).request(MediaType.APPLICATION_JSON).get(Response.class);
		return response;
	}

	@Test
	public void shouldReturnA204WhenItemIsSaved() {
		final Response response = putItem(new Document("2"));
		assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());

	}

	private Response putItem(final Document information) {
		String path = "20";
		Document entity = new Document(path);
		final Response response = documentResource().path(path).request().put(Entity.json(entity));
		return response;
	}

	protected WebTarget documentResource() {
		return target("documents");
	}

}
