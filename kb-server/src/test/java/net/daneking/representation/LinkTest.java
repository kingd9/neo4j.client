package net.daneking.representation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LinkTest {
	@Test
	public void shouldInstatiateWithContructor() {
		Link link = setupLink();
		assertNotNull(link);
		assertEquals("name", link.getName());
		assertEquals("uri", link.getUri());
		assertEquals("mediaType", link.getMediaType());
	}

	private Link setupLink() {
		String name = "name";
		String rel = "uri";
		String mediaType = "mediaType";
		Link link = new Link(name, rel, mediaType);
		return link;
	}
}
