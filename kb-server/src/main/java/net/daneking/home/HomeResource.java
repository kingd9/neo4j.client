package net.daneking.home;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.daneking.home.activity.StartingPoint;
import net.daneking.representation.Representation;

@Path("/")
public class HomeResource {
	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response home() {
		Representation<String> wrappedEntity = new StartingPoint().getInitialLinks(uriInfo.getAbsolutePath().toString());
		return Response.ok(wrappedEntity).build();
	}

}
