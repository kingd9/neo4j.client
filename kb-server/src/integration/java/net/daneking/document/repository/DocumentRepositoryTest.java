package net.daneking.document.repository;

import static org.junit.Assert.assertNotNull;
import net.daneking.document.domain.Document;

import org.junit.Before;
import org.junit.Test;

public class DocumentRepositoryTest {
	private DocumentRepository repository;

	@Before
	public void setUp() {
		repository = DocumentRepository.current();
	}

	@Test
	public void shouldFindInformationAfterSavingItem() {
		repository.save(new Document(2));
		Document information = repository.find(2);
		assertNotNull(information);
	}

}
