package edu.ni.microservices.setting.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.ni.microservices.setting.domain.Country;
import edu.ni.microservices.setting.exception.RecordNotFoundException;
import edu.ni.microservices.setting.exception.UniqueConstraintException;
import edu.ni.microservices.setting.exception.ValidateRecordException;
import edu.ni.microservices.setting.service.CountryService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private Environment env;

	@GetMapping("/countries")
	public List<Country> retrieveAllCountries() {
		List<Country> countries = countryService.findAllCountries();
		log.info("\n retrieveAllCountries {} \n Port: {}", countries, env.getProperty("server.port"));

		return countries;
	}

	@GetMapping("/countries/{id}")
	public Country retrieveCountryById(@PathVariable Long id) {

		Country country = countryService.getCountryById(id);
		if (null == country) {
			throw new RecordNotFoundException(" No country with this Id", id);
		}
		log.info("\n Country retrieveCountryById {}\n Port {}", country, env.getProperty("server.port"));

		return country;
	}

	@PostMapping("/countries")
	public ResponseEntity<Country> save(@RequestBody Country newCountry)
			throws UniqueConstraintException, ValidateRecordException {
		log.info("\n Country Instance Port: {}", env.getProperty("server.port"));
		log.info("\n newCountry {}", newCountry);

		if (newCountry.getId() != null)
			throw new ValidateRecordException("Key should not exist in Request. Remove 'id' from request body");

		if (countryService.nameExists(newCountry.getName()))
			throw new UniqueConstraintException("Country already exists with name", newCountry.getName());

		Country savedCountry = countryService.saveCountry(newCountry);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCountry.getId()).toUri();

		return ResponseEntity.created(location).body(savedCountry);
	}

	@DeleteMapping("/countries/{id}")
	public void delete(@PathVariable Long id) {
		Country country = countryService.getCountryById(id);
		if (null == country)
			throw new RecordNotFoundException(" No country with this Id", id);
		countryService.deleteById(id);
	}

	@PutMapping("/countries")
	public ResponseEntity<Country> update(@RequestBody Country country)
			throws ValidateRecordException, UniqueConstraintException {
		log.info("\n Country Instance Port: {}", env.getProperty("server.port"));
		log.info("\n newCountry {}", country);

		if (null == country.getId() || country.getId() < 1)
			throw new ValidateRecordException("Key should  exist in request body and equivalent to  path.");

		Country countryExisting = countryService.getCountryById(country.getId());

		if (countryExisting.equals(country))
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(country);

		Country savedCountry = countryService.saveCountry(country);

		return ResponseEntity.status(HttpStatus.OK).body(savedCountry);
	}

}
