package net.daneking.document.activity;

import net.daneking.document.domain.Document;
import net.daneking.document.repository.DocumentRepository;
import net.daneking.representation.Representation;

public class FindDocument {
	private final String baseUri;

	public FindDocument(final String baseUri) {
		this.baseUri = baseUri;

	}

	public Representation<Document> findDocument(final int id) {
		final DocumentRepository documentRepository = DocumentRepository.current();
		return createLinks(this.baseUri, documentRepository.find(id));
	}

	private Representation<Document> createLinks(final String baseUri, final Document document) {
		Representation<Document> documentRepresentation = new Representation<Document>(document);
		documentRepresentation.createSelfLink(baseUri);
		return documentRepresentation;
	}

}
