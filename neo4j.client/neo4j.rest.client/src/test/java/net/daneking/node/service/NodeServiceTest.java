package net.daneking.node.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.daneking.node.NodeRepresentation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

public class NodeServiceTest {
	private static final String REST_URL = "http://localhost:7474/db/data/node/3";
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private NodeService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(restTemplate.getForObject(REST_URL, String.class)).thenReturn("Message SUCCESS result: {}");
	}

	@Test
	public void getNode() {
		service.getNode(3);
		verify(restTemplate).getForObject(REST_URL, NodeRepresentation.class);
	}
}
