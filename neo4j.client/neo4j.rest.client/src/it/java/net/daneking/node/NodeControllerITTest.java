package net.daneking.node;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import net.daneking.WebInitializer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = WebInitializer.class)
public class NodeControllerITTest {
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Autowired
	private NodeController controller;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void shouldReturnResourceWhenGetIsCalled() {
		mockServer.expect(requestTo("/node/5")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("{\"number\":5 }", MediaType.APPLICATION_JSON));
		ResponseEntity<NodeRepresentation> response = restTemplate.getForEntity("/node/5", NodeRepresentation.class);
		NodeRepresentation body = response.getBody();
		// assertEquals(body.getNumber(), Integer.valueOf(5));
		mockServer.verify();

	}

}