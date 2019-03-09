package edu.ndsi.microservices.news.domain;

import java.math.BigDecimal;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
@ToString(callSuper = true)

public class HiredSubscriber extends Subscriber {

	private BigDecimal articlesPerWeek;
}
