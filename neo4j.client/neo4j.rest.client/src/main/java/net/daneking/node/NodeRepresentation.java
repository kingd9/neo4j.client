package net.daneking.node;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeRepresentation {

	private Object extensions;
	private Object data;
	private String outgoing_relationships;
	private String incoming_relationships;
	private String all_relationships;
	private String self;
	private String properties;
	private String create_relationship;

}
