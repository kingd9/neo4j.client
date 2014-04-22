package net.daneking.document.repository;

import java.util.HashMap;
import java.util.Map;

import net.daneking.document.domain.Document;

class DocumentRepository {
	private static final DocumentRepository theRepository = new DocumentRepository();
	private static int num = 1;
	private final Map<Integer, Document> backingStore = new HashMap<Integer, Document>();

	public DocumentRepository() {
		save(new Document(20));
	}

	public static DocumentRepository current() {
		return theRepository;
	}

	public Document find(final int id) {
		backingStore.put(Integer.valueOf(num), new Document(num++));
		return backingStore.get(id);
	}

	public void save(final Document document) {
		backingStore.put(document.getId(), document);
	}

}
