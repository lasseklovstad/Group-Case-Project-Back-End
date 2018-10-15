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


	public Contact() {
	}

	public Contact(String contactType, String contactDetail) {
		this.contactType = contactType;
		this.contactDetail = contactDetail;
	}
}
