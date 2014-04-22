package net.daneking.people.repository;

import net.daneking.people.domain.Person;

public class SavePerson {

	public void save(final Person person) {
		final PeopleRepository peopleRepository = PeopleRepository.current();
		peopleRepository.save(person);
	}

}
