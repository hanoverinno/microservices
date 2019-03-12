package edu.ndsi.microservices.news.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.ndsi.microservices.news.domain.bean.CountryBean;

//@FeignClient("country-setting")
@FeignClient("zuul-gateway")
public interface CountryProxy {

	@GetMapping("/setting/countries")
	public List<CountryBean> retrieveAllCountries();

	@GetMapping("/setting/countries/{id}")
	public CountryBean retrieveCountryById(@PathVariable Long id) throws Exception;

}
