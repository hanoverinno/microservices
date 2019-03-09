package edu.ndsi.microservices.news.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.ndsi.microservices.news.utils.Gender;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "SEQ_SUBSCRIBER", allocationSize = 1, initialValue = 1)

@Inheritance(strategy= InheritanceType.JOINED)

public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBSCRIBER")
	private Long id;

	private String fullName;
	
	@Past
	private Date subscriptionDate;
	private boolean active;

	@Email
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'U'")
	private Gender gender;
	
	@OneToOne(mappedBy="subscriber")
	@JsonManagedReference
	private SubscriberAdditionalDetails additionalDetails;
}




