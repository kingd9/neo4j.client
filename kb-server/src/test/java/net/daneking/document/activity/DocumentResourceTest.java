package net.daneking.document.activity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.daneking.document.DocumentResource;
import net.daneking.document.domain.Document;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DocumentResourceTest {
	@Mock
	private DocumentActivityFactory factory;

	private DocumentResource resource;
	private Document document;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setupDocumentActivityFactoryExpectations();
		resource = new DocumentResource();
		resource.setFactory(factory);
		document = new Document();
	}

	private void setupDocumentActivityFactoryExpectations() {
		when(factory.getSaveDocument()).thenReturn(new SaveDocument());
	}

	@Test
	public void shouldCallSaveDocumentOnSave() {
		resource.save("2", document);
		verify(factory).getSaveDocument();

	}

}
