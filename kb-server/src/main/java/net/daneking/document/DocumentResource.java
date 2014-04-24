package net.daneking.document;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import net.daneking.document.activity.DocumentActivityFactory;
import net.daneking.document.activity.FindDocument;
import net.daneking.document.domain.Document;
import net.daneking.representation.Representation;

@Path("documents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentResource {
	@Context
	private UriInfo uriInfo;
	private DocumentActivityFactory factory;

	public void setFactory(final DocumentActivityFactory factory) {
		this.factory = factory;
	}

	private String getPath() {
		return uriInfo.getAbsolutePath().toString();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final int id) {
		Representation<Document> documentRepresentation = new FindDocument(getPath()).findDocument(id);
		return buildResponse(documentRepresentation).build();
	}

	private ResponseBuilder buildResponse(final Representation<Document> documentRepresentation) {
		ResponseBuilder returnReponse;
		if (documentRepresentation.getEntity() == null) {
			returnReponse = Response.status(Status.NOT_FOUND);
		} else {
			returnReponse = Response.ok(documentRepresentation);
		}
		return returnReponse;
	}

	@PUT
	@Path("/{id}")
	public Response save(@PathParam("id") final Integer id, final Document document) {
		document.setId(id);
		getFactory().getSaveDocument().save(document);
		return Response.noContent().build();
	}

	public DocumentActivityFactory getFactory() {
		if (factory == null) {
			factory = new DocumentActivityFactory();
		}
		return factory;
	}

	@POST
	public Response create() {
		Document document = getFactory().getCreateDocument().create();
		return Response.status(Status.CREATED).build();
	}

}
