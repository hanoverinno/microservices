package edu.ndsi.microservices.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ndsi.microservices.news.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
