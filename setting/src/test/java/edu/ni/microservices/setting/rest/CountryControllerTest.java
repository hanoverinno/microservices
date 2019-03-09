package edu.ni.microservices.setting.rest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ni.microservices.setting.domain.Country;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "eureka.client.enabled=false" })
@Slf4j
public class CountryControllerTest {

	@LocalServerPort
	private int localPort;

	private static String url;
	private static HttpHeaders headers = new HttpHeaders();

	@Before
	public void setup() {
		// set initials
		url = String.format("%s%s%s", "http://localhost:", localPort, "/countries/");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void test_retrieveAllCountries_return_listOfCountries() throws Exception {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		TestRestTemplate restTemplate = new TestRestTemplate();
		log.info("\n url : {} \n entity: {} \n restTemplate: {}", url, entity, restTemplate);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		log.info("\n Test retrieveAllCountries {}", response);

		String expected = "[{\"id\":30001,\"name\":\"Egypt\",\"countryCode\":\"+2\"},{\"id\":30002,\"name\":\"USA\",\"countryCode\":\"+1\"}]";

		assertEquals(HttpStatus.OK, response.getStatusCode());
		log.info("\n expected : {} \n got: {}", expected, response.getBody());

		JSONAssert.assertEquals(expected, response.getBody(), true);

	}

	@Test
	public void test_save_return_newCountryWithID() throws Exception {

		String expected = "{\"id\":1,\"name\":\"UK\",\"countryCode\":\"+44\"}";

		HttpEntity<Country> entity = new HttpEntity<>(new Country("UK", "+44"));

		TestRestTemplate restTemplate = new TestRestTemplate();
		log.info("\n url : {} \n entity: {} \n restTemplate: {}", url, entity, restTemplate);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		log.info("\n Test test_save_return_newCountryWithID {}", response);

		log.info("\n expected : {} \n got: {}", expected, response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());

		JSONAssert.assertEquals(expected, response.getBody(), true);

	}

	@Test
	public void test_save_return_uniqueNameException() {

		HttpEntity<Country> entity = new HttpEntity<>(new Country("Egypt", "+20"));

		TestRestTemplate restTemplate = new TestRestTemplate();
		log.info("\n url : {} \n entity: {} \n restTemplate: {}", url, entity, restTemplate);

		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		log.info("\n Test test_save_return_uniqueNameException {}", response);

		assertEquals(HttpStatus.CONFLICT, response.getStatusCode());

	}

	@Test
	public void test_update_return_updatedCountry() throws JSONException {

		url.concat("/30002");
		String expected = "{\"id\":30002,\"name\":\"UK\",\"countryCode\":\"+44\"}";

		HttpEntity<Country> entity = new HttpEntity<>(new Country(30002l, "Norway", "+47"));

		TestRestTemplate restTemplate = new TestRestTemplate();
		log.info("\n url : {} \n entity: {} \n restTemplate: {}", url, entity, restTemplate);

		restTemplate.put(url, entity);

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		log.info("\n test_update_return_updatedCountry : {} \n got: {}", expected, response);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		// JSONAssert.assertEquals(expected, response.getBody(), false);

		// re-submit with same values
		// entity = new HttpEntity<>(new Country(30002l, "Norway", "+47"));
		// restTemplate.put(url, entity);
		// ResponseEntity<String> responseOfUnmidifiedCountry = restTemplate.getForEntity(url, String.class);

		// assertEquals(HttpStatus.NOT_MODIFIED, responseOfUnmidifiedCountry.getStatusCode());

	}

}
