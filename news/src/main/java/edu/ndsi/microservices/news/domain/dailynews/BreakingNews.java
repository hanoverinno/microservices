package edu.ndsi.microservices.news.domain.dailynews;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BN")
public class BreakingNews extends DailyContent {

}
