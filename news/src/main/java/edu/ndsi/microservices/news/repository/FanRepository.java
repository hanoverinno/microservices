package edu.ndsi.microservices.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ndsi.microservices.news.domain.Fan;

@Repository
public interface FanRepository extends JpaRepository<Fan, Long> {

}
