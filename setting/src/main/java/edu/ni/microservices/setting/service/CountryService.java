package edu.ni.microservices.setting.service;

import java.util.List;

import edu.ni.microservices.setting.domain.Country;

public interface CountryService {

	List<Country> findAllCountries();

	Country saveCountry(Country country);

	Country getCountryById(Long id);

	boolean nameExists(String name);

	Country collectSavedCountryInCache(Country country);

	void deleteById(Long id);
}
