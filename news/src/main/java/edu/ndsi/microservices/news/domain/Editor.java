package edu.ndsi.microservices.news.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Editor extends HiredSubscriber {

	private BigDecimal ratePer500Word;

}
