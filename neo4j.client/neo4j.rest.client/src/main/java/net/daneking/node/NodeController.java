package net.daneking.node;

import net.daneking.node.service.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/node", produces = MediaType.APPLICATION_JSON_VALUE)
public class NodeController {
	@Autowired
	private NodeService service;

	@RequestMapping("/service_alive")
	public @ResponseBody
	String isAlive() {
		return "I'm alive";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<NodeRepresentation> get(@PathVariable("id") final Integer id) {
		NodeRepresentation representation = service.getNode(id);
		return new ResponseEntity<NodeRepresentation>(representation, HttpStatus.OK);
	}

}
