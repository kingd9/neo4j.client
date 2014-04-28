package net.daneking.document.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.daneking.document.domain.Document;

public class DocumentRepository {
	private static final DocumentRepository theRepository = new DocumentRepository();
	private static int num = 1;
	private final Map<String, Document> backingStore = new HashMap<String, Document>();

	public DocumentRepository() {

	}

	public static DocumentRepository current() {
		return theRepository;
	}

	public Document find(final String id) {
		return backingStore.get(id);
	}

	public void save(final Document document) {
		backingStore.put(document.getIdentifier(), document);
	}

	public Collection<Document> findAll() {
		return backingStore.values();
	}

	public void clear() {
		backingStore.clear();
	}

}
