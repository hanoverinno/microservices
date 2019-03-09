package edu.ndsi.microservices.news.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.ndsi.microservices.news.domain.bean.CountryBean;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@SequenceGenerator(name = "SEQ_ADD_DETAIL", allocationSize = 1, initialValue = 1)

public class SubscriberAdditionalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBSCRIBER")
	private Long id;

	private String phone;
	private String address;
	private String city;
	private Date birthDate;

	// unidirectional relation
//	@ManyToOne
//	@JoinColumn(name = "country_id")
//	private Country country;

	private Long country;

	@Transient
	private CountryBean countryBean;

	@OneToOne
	@JoinColumn(name = "main_data", foreignKey = @ForeignKey(name = "FK_SUB_ADD_DETAILS"))
	@JsonBackReference
	@ToString.Exclude
	private Subscriber subscriber;
}
