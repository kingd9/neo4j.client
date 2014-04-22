package net.daneking.people;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import net.daneking.people.domain.Person;
import net.daneking.people.repository.FindPerson;
import net.daneking.people.repository.SavePerson;
import net.daneking.representation.Representation;

@Path("people")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PeopleResource {
	@Context
	private UriInfo uriInfo;

	private String getPath() {
		return uriInfo.getAbsolutePath().toString();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final int id) {
		return buildPersonResponse(id).build();
	}

	private ResponseBuilder buildPersonResponse(final int id) {
		Representation<Person> personRepresentation = new FindPerson(getPath()).findPerson(id);
		ResponseBuilder returnReponse;
		if (personRepresentation.getEntity() == null) {
			returnReponse = Response.status(Status.NOT_FOUND);
		} else {
			returnReponse = Response.ok(personRepresentation);
		}
		return returnReponse;
	}

	@PUT
	public Response save(final Person person) {
		new SavePerson().save(person);
		return Response.noContent().build();
	}

	@GET
	@Path("/test")
	public Person get() {
		return new Person(2);
	}

}
