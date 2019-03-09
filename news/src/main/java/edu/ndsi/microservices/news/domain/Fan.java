package edu.ndsi.microservices.news.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Fan extends Subscriber{
	
	private String description; 
	
	@ManyToMany(mappedBy="fans")
	@JsonIgnore //static type of filtering
	private Set<Author> authors;
}







