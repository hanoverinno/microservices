package edu.ni.microservices.setting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ni.microservices.setting.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findByNameIgnoreCase(String name);

}
