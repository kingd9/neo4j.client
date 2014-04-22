package net.daneking.people.repository;

import static org.junit.Assert.assertNotNull;
import net.daneking.people.domain.Person;

import org.junit.Before;
import org.junit.Test;

public class PeopleRepositoryTest {
	private PeopleRepository repository;

	@Before
	public void setUp() {
		repository = PeopleRepository.current();
	}

	@Test
	public void shouldFindInformationAfterSavingItem() {
		repository.save(new Person(2));
		Person information = repository.find(2);
		assertNotNull(information);
	}

}
