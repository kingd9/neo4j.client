package net.daneking.people;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.daneking.people.domain.Person;

import org.junit.Test;

import utils.TestSupport;

public class PeopleResourceTest extends TestSupport<PeopleResource> {

	@Test
	public void shouldReturnA404WhenItemIsNotFound() {
		final Response response = getItem("2");
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}

	@Test
	public void shouldReturnA200WhenItemIsFound() {
		Person person = new Person(20);
		person.setFirstName("Joe");
		person.setLastName("Smith");

		final Response response = getItem("20");
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}

	private Response getItem(final String id) {
		final Response response = peopleResource().path(id).request(MediaType.APPLICATION_JSON).get(Response.class);
		return response;
	}

	@Test
	public void shouldReturnA204WhenItemIsSaved() {
		final Response response = postItem(new Person(2));
		assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());

	}

	private Response postItem(final Person information) {
		final Response response = peopleResource().request().put(
				Entity.entity(new Person(2), MediaType.APPLICATION_JSON));
		return response;
	}

	protected WebTarget peopleResource() {
		return target("people");
	}

}
