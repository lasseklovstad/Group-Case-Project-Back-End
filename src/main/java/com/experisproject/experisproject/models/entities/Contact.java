package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Contact {
	@Id
	@GeneratedValue
	private int contactId;

	@NotNull
	private String contactType;
	@NotNull
	private String contactDetail;

	@ManyToOne
	@JoinColumn(name = "personId")
	@NotNull
	private Person person;

	public Contact() {
	}

	public Contact(@NotNull String contactType, @NotNull String contactDetail, @NotNull Person person) {
		this.contactType = contactType;
		this.contactDetail = contactDetail;
		this.person = person;
	}

	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)
	//   contact_id INT NOT NULL,
	//  contact_type VARCHAR(64) NOT NULL,
	//  contact_detail VARCHAR(64) NOT NULL,
	//  person_id INT NOT NULL,
	//  PRIMARY KEY (contact_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)
}
