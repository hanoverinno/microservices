package edu.ndsi.microservices.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ndsi.microservices.news.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
