package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int personId;

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	@OneToOne(name ="")
	private Coach coach;
	//addressId as foreign key, reference address(addressId)
	//  person_id INT NOT NULL,
	//  first_name VARCHAR(64) NOT NULL,
	//  last_name VARCHAR(64) NOT NULL,
	//  date_of_birth DATE NOT NULL,
	//  address_id VARCHAR(64),
	//  PRIMARY KEY (person_id),
	//  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)

	public Person() {
	}

	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
}
