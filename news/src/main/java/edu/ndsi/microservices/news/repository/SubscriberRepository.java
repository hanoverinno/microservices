package edu.ndsi.microservices.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import edu.ndsi.microservices.news.domain.Country;
import edu.ndsi.microservices.news.domain.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

	List<Subscriber> findByActive(boolean active);

	List<Subscriber> findByFullNameAndActive(String fullname, boolean active);

	List<Subscriber> findByFullNameAndEmail(String fn, String e);

	List<Subscriber> findByFullNameIgnoreCaseAndEmail(String fn, String e);

	List<Subscriber> findByFullNameAndActiveAllIgnoreCase(String fn, boolean active);

	List<Subscriber> findByFullNameAndActiveAndEmailAllIgnoreCase(String fn, boolean active, String e);

	List<Subscriber> findByAdditionalDetailsCity(String city);

	// List<Subscriber> findByAdditionalDetailsCountry(Country country);

}
