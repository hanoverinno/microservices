package edu.ndsi.microservices.news.domain.dailynews;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@DiscriminatorValue(value="M")
public class AudienceMessage extends DailyContent{
	
}
