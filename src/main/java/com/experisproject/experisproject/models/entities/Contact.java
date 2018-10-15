package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private int contactId;

	private String contactType;
	private String contactDetail;
	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)
	//   contact_id INT NOT NULL,
	//  contact_type VARCHAR(64) NOT NULL,
	//  contact_detail VARCHAR(64) NOT NULL,
	//  person_id INT NOT NULL,
	//  PRIMARY KEY (contact_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

	public Contact() {
	}

	public Contact(String contactType, String contactDetail) {
		this.contactType = contactType;
		this.contactDetail = contactDetail;
	}
}
