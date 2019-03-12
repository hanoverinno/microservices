package edu.ndsi.microservices.news.domain.dailynews;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "M")
public class AudienceMessage extends DailyContent {

}
