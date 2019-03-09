package edu.ni.microservices.setting.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
//@NoArgsConstructor
@SequenceGenerator(name = "SEQ_COUNTRY", allocationSize = 1, initialValue = 1)
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COUNTRY")
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;

	@Pattern(regexp = "^\\+(?:[0-9]){1,3}")
	private String countryCode;

	public Country() {

	}

	public Country(String name, String countryCode) {
		this.name = name;
		this.countryCode = countryCode;
	}

	public Country(Long id, String name, String countryCode) {
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
	}

}
