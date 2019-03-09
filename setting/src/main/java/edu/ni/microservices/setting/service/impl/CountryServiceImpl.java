package edu.ni.microservices.setting.service.impl;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import edu.ni.microservices.setting.domain.Country;
import edu.ni.microservices.setting.exception.RecordNotFoundException;
import edu.ni.microservices.setting.repository.CountryRepository;
import edu.ni.microservices.setting.service.CountryService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	/**
	 * From https://code.google.com/p/ehcache-spring-annotations/wiki/UsingCacheable
	 * 
	 * Only external method calls coming in through the proxy are intercepted. This
	 * means that self-invocation, in effect, a method within the target object
	 * calling another method of the target object, will not lead to an actual cache
	 * interception at runtime even if the invoked method is marked with @Cacheable.
	 */
	@Autowired
	CountryService countryService;

	@Cacheable("allCountries")
	public List<Country> findAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries;
	}

	@Override
	public Country saveCountry(Country country) {
		Country savedCountry = countryRepository.save(country);
		if (savedCountry != null)
			countryService.collectSavedCountryInCache(savedCountry);
		return savedCountry;
	}

	@Override
	@Cacheable(cacheNames = { "countries" }, key = "#id", sync = true)

	public Country getCountryById(Long id) {

		Optional<Country> country = countryRepository.findById(id);

		if (!country.isPresent())
			throw new RecordNotFoundException(" No country with this Id", id);

		return country.get();
	}

	@Override
	public boolean nameExists(String name) {
		Country country = new Country(name, null);

		ExampleMatcher matcher = ExampleMatcher.matchingAll().withMatcher("name", ignoreCase());
		Example<Country> example = Example.of(country, matcher);

		if (countryRepository.exists(example))
			return true;

		return false;
	}

	/**
	 * Don't add never ever @CachePut and @Cacheable in @Caching
	 */
	@Caching(evict = { @CacheEvict(cacheNames = "allCountries", allEntries = true) }, put = {
			@CachePut(cacheNames = { "countries" }, key = "#country.id") })

	public Country collectSavedCountryInCache(Country country) {
		log.info("\n collectSavedCountryInCache {}", country);
		return country;
	}

	@Caching(evict = { @CacheEvict(cacheNames = "allCountries", allEntries = true),
			@CacheEvict(cacheNames = "countries", key = "#id") })

	public void deleteById(Long id) {
		countryRepository.deleteById(id);
	}

}
