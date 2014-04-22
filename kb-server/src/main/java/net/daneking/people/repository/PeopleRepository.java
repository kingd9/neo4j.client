package net.daneking.people.repository;

import java.util.HashMap;
import java.util.Map;

import net.daneking.people.domain.Person;

class PeopleRepository {
	private static final PeopleRepository theRepository = new PeopleRepository();
	private static int num = 1;
	private final Map<Integer, Person> backingStore = new HashMap<Integer, Person>();

	public PeopleRepository() {
		save(new Person(20));
	}

	public static PeopleRepository current() {
		return theRepository;
	}

	public Person find(final int id) {
		backingStore.put(Integer.valueOf(num), new Person(num++));
		return backingStore.get(id);
	}

	public void save(final Person person) {
		backingStore.put(person.getId(), person);
	}

}
