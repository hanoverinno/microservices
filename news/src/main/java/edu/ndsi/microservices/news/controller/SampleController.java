package edu.ndsi.microservices.news.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.ndsi.microservices.news.domain.Author;
import edu.ndsi.microservices.news.domain.Fan;
import edu.ndsi.microservices.news.domain.bean.CountryBean;
import edu.ndsi.microservices.news.proxy.CountryProxy;
import edu.ndsi.microservices.news.repository.AuthorRepository;
import edu.ndsi.microservices.news.repository.FanRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SampleController {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private FanRepository fanRepository;

	@Autowired
	private CountryProxy countryProxy;

	@GetMapping("/")
	public String helloWorld() {
		return "Hello New World!";
	}

	@GetMapping("/authors/{id}")
	public Author retrieveAuthors(@PathVariable Long id) throws Exception {
		Optional<Author> authorObj = authorRepository.findById(id);
		Author author = authorObj.get();
		log.info("{}", author);
//		for (int i = 0; i < authors.size(); i++) {
//			SubscriberAdditionalDetails details = authors.get(i).getAdditionalDetails();

//			ResponseEntity<CountryBean> respnseEntity =countryProxy.retrieveCountryById(details.getCountry());

		CountryBean countryBean = new CountryBean();
//		countryBean.setId(1l);
//		countryBean.setName("Chiko");
		countryBean = countryProxy.retrieveCountryById(author.getAdditionalDetails().getCountry());
		log.info("====================== {}", countryBean);

//			authors.get(i).getAdditionalDetails().setCountryBean(countryBean);
//		}
		author.getAdditionalDetails().setCountryBean(countryBean);
		return author;
	}

	@GetMapping("/fans")
	public List<Fan> retrieveFans() {
		return fanRepository.findAll();
	}
}
