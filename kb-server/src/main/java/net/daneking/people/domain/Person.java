package net.daneking.people.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement()
public class Person {
	protected static final Logger _logger = LoggerFactory.getLogger(Person.class);

	public Person() {

	}

	public Person(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	private Integer id;

	private String firstName;

	private String lastName;

}
