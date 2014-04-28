package net.daneking.document.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import net.daneking.document.domain.Document;

import org.junit.Before;
import org.junit.Test;

public class DocumentRepositoryTest {
	private DocumentRepository repository;

	@Before
	public void setUp() {
		repository = DocumentRepository.current();
		repository.clear();
	}

	@Test
	public void shouldFindObjectAfterSavingItem() {
		String identifier = "2";
		repository.save(new Document(identifier));
		Document document = repository.find(identifier);
		assertNotNull(document);
	}

	@Test
	public void shouldReturnAllDocumentsWhenFindAllIsCalled() {
		repository.save(new Document("1"));
		repository.save(new Document("2"));
		Collection<Document> documents = repository.findAll();
		assertEquals(2, documents.size());
	}

}
