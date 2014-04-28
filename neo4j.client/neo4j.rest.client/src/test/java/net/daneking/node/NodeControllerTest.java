package net.daneking.node;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.daneking.node.service.NodeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class NodeControllerTest {
	private static final int TEST_ID = Integer.valueOf(5);
	@Mock
	private NodeService service;
	@InjectMocks
	private NodeController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(service.getNode(isA(Integer.class))).thenReturn(expectedNodeRepresentation(5));
	}

	@Test
	public void shouldCallServiceWhenGetIsCalled() {
		ResponseEntity<NodeRepresentation> entity = controller.get(TEST_ID);
		verify(service).getNode(TEST_ID);
		assertThat(entity.getBody(), equalTo(expectedNodeRepresentation(TEST_ID)));

	}

	private NodeRepresentation expectedNodeRepresentation(final int id) {
		NodeRepresentation representation = new NodeRepresentation();
		// representation.setNumber(id);
		return representation;
	}
}
