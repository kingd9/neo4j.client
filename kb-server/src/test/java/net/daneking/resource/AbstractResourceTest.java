package net.daneking.resource;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AbstractResourceTest {
	@Test
	public void shouldInstantiateListIfConstructedWithNull() {
		AbstractResource resource = new AbstractResource(null) {
		};
		assertNotNull(resource.getLinks());
	}

}
