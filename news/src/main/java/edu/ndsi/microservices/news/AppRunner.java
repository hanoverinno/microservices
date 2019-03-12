package edu.ndsi.microservices.news;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {

//	private final CountryService countryService;
//
//	public AppRunner(CountryService countryService) {
//		this.countryService = countryService;
//	}

	@Override
	public void run(String... args) throws Exception {

		log.info("\n=====================Start Call");
//		log.info("1- >>>> {}", countryService.getCountryById(30001l));
//		log.info("2- >>>> {}", countryService.getCountryById(30001l));
//		
//		log.info("3- >>>> {}", countryService.getCountryById(30002l));
//		log.info("4- >>>> {}", countryService.getCountryById(30002l));
//
//		// save new object
//		countryService.saveCountry(new Country("France"));
//		
//		countryService.saveCountry(new Country(30001l, "EGY"));
//		
//		// call every object again
//		
//		log.info("5- >>>> {}", countryService.getCountryById(30001l));
//		log.info("5- >>>> {}", countryService.getCountryById(30001l));
//		log.info("6- >>>> {}", countryService.getCountryById(30002l));
//		
//		//call the new object twice
//		log.info("7- >>>> {}", countryService.getCountryById(1l));
//		log.info("8- >>>> {}", countryService.getCountryById(1l));
//		
		log.info("\n====================End Call");

	}

}
