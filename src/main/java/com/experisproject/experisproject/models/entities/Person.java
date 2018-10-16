package com.experisproject.experisproject.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int personId;

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	@OneToOne(mappedBy ="person", cascade = CascadeType.ALL)//if a person is deleted and is a coach, no longer a coach
	private Coach coach;

	@ManyToOne
	@MapsId("addressId")
	@JoinColumn(name = "addressId") //referencedColumnName =""?
	private Address address;
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
