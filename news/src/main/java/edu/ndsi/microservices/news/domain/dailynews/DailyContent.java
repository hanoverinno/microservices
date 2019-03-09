package edu.ndsi.microservices.news.domain.dailynews;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="content_type", discriminatorType=DiscriminatorType.STRING)

public class DailyContent {
	
	@Id
	private Long id;
	
	//@Column(length=1000)
	@Size(max=1000)
	private String content;
	
	

}
