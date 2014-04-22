package net.daneking.document.repository;

import net.daneking.document.domain.Document;

public class SaveDocument {

	public void save(final Document document) {
		final DocumentRepository repository = DocumentRepository.current();
		repository.save(document);
	}

}
