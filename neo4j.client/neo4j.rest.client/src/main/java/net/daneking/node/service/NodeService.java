package net.daneking.node.service;

import net.daneking.node.NodeRepresentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;

@Component
public class NodeService {
	private static final String BASE_URL = "http://localhost:7474";
	private static final String NODE_URL = "/db/data/node/";

	@Autowired
	private RestOperations restTemplate;

	public NodeRepresentation getNode(final Integer id) {
		ResponseEntity<NodeRepresentation> httpResult = null;
		try {
			httpResult = restTemplate.getForEntity(createRestUrl(id), NodeRepresentation.class);
		} catch (HttpStatusCodeException e) {
		} catch (RuntimeException e) {
			System.out.println(e);

		}
		return httpResult.getBody();
	}

	private String createRestUrl(final int id) {
		return BASE_URL + NODE_URL + id;
	}

}
