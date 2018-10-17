package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contact {
	@Id
	@GeneratedValue
	private int contactId;

	private String contactType;
	private String contactDetail;

	@OneToOne
	@JoinColumn(name = "contactId")
	private Person person;

	public Contact() {
	}

	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)
	//   contact_id INT NOT NULL,
	//  contact_type VARCHAR(64) NOT NULL,
	//  contact_detail VARCHAR(64) NOT NULL,
	//  person_id INT NOT NULL,
	//  PRIMARY KEY (contact_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

}
