package net.daneking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.support.
	 * AbstractAnnotationConfigDispatcherServletInitializer
	 * #getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.support.
	 * AbstractAnnotationConfigDispatcherServletInitializer
	 * #getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer
	 * #getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * Web layer configuration enabling Spring MVC, Spring Hateoas
	 * {@link EntityLinks}.
	 * 
	 * @author Oliver Gierke
	 */
	@Configuration
	@EnableWebMvc
	@ComponentScan(excludeFilters = @Filter({ Service.class, Configuration.class }))
	public static class WebConfiguration extends WebMvcConfigurationSupport {

		@Autowired
		ApplicationContext context;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.web.servlet.config.annotation.
		 * WebMvcConfigurationSupport
		 * #configureContentNegotiation(org.springframework
		 * .web.servlet.config.annotation.ContentNegotiationConfigurer)
		 */
		@Override
		protected void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
			configurer.defaultContentType(MediaType.APPLICATION_JSON);
		}

		@Bean
		public RestOperations restOperations() {
			RestTemplate rest = new RestTemplate();
			// this is crucial!
			rest.getMessageConverters().add(0, mappingJacksonHttpMessageConverter());
			return rest;
		}

		@Bean
		public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
			// converter.setObjectMapper(myObjectMapper());
			return converter;
		}

		/*
		 * @Bean public ObjectMapper myObjectMapper() { // your custom
		 * ObjectMapper here }
		 */
	}
}