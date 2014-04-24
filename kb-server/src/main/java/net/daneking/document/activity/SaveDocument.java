package net.daneking.document.activity;

import net.daneking.document.domain.Document;
import net.daneking.document.repository.DocumentRepository;

public class SaveDocument {

	public void save(final Document document) {
		final DocumentRepository repository = DocumentRepository.current();
		repository.save(document);
	}

}
