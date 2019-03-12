package edu.ndsi.microservices.news.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Author extends HiredSubscriber {

	private BigDecimal ratePer1000Word;

	@OneToMany(mappedBy = "author")
	@ToString.Exclude
	private List<Article> articles;

	@ManyToMany
	@JsonIgnore // static type of filtering
	@ToString.Exclude
	private Set<Fan> fans;

}
