package utils;

import java.lang.reflect.ParameterizedType;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

public class TestSupport<T> extends JerseyTest {

	@Override
	protected Application configure() {
		ResourceConfig resourceConfig = new ResourceConfig(getPersistentClass());
		resourceConfig.register(JacksonFeature.class);
		return resourceConfig;
	}

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	private Class<T> getPersistentClass() {
		if (persistentClass == null) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return persistentClass;
	}

}
