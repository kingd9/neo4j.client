package net.daneking.people.repository;

import net.daneking.people.domain.Person;
import net.daneking.representation.Representation;

public class FindPerson {
	private final String baseUri;

	public FindPerson(final String baseUri) {
		this.baseUri = baseUri;

	}

	public Representation<Person> findPerson(final int id) {
		final PeopleRepository peopleRepository = PeopleRepository.current();
		return createLinks(this.baseUri, peopleRepository.find(id));
	}

	private Representation<Person> createLinks(final String baseUri, final Person person) {
		Representation<Person> personRepresentation = new Representation<Person>(person);
		personRepresentation.createSelfLink(baseUri);
		return personRepresentation;
	}

}
