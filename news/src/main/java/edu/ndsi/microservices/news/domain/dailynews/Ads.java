package edu.ndsi.microservices.news.domain.dailynews;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AD")
public class Ads extends DailyContent {

}
