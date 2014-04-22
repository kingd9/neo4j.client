package net.daneking.representation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class RepresentationTest {

	private Representation<String> representation;

	@Before
	public void setUp() {
		representation = new Representation<String>("");
	}

	@Test
	public void shouldReturnNullWhenGetLinkByNameAndLinksAreNull() {
		Link link = representation.getLinkByName("name");
		assertNull(link);
	}

	@Test
	public void shouldReturnNullWhenGetLinkByNameDoesNotFindAnything() {
		representation.createLink("a", "b", "c");
		Link link = representation.getLinkByName("name");
		assertNull(link);
	}

	@Test
	public void shouldReturnLinkWhenGetLinkByNameIsFound() {
		addLink(representation, "o", "m", "p");
		addLink(representation, "a", "b", "c");
		addLink(representation, "b", "d", "f");
		Link link = representation.getLinkByName("a");
		verifyLink(link, "a", "b", "c");
	}

	private void addLink(final Representation<String> representation, final String... values) {
		assert (values.length == 2);
		representation.createLink(values[0], values[1], values[2]);
	}

	private void verifyLink(final Link link, final String... values) {
		assert (values.length == 2);
		assertEquals(values[0], link.getName());
		assertEquals(values[1], link.getUri());
		assertEquals(values[2], link.getMediaType());
	}
}
