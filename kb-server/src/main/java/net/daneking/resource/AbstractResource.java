package net.daneking.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import lombok.Data;

@Data
public abstract class AbstractResource {

	private final List<Link> links;

	public AbstractResource(final List<Link> links) {
		this.links = links == null ? new ArrayList<Link>() : links;
	}

}
