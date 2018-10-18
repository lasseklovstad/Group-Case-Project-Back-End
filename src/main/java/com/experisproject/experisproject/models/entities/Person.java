package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue
	private int personId;

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "addressId") //referencedColumnName =""?
	private Address address;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy ="person", cascade = CascadeType.ALL)//if a person is deleted and is a coach, no longer a coach
	private Coach coach;
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL) //if a person is deleted and is a player, no longer a player
	private Player player;
	@OneToOne(mappedBy = "person")
	private Contact contact;
	@OneToOne(mappedBy = "person")
	private Owner owner;
	*/



	public Person() {
	}

	//addressId as foreign key, reference address(addressId)
	//  person_id INT NOT NULL,
	//  first_name VARCHAR(64) NOT NULL,
	//  last_name VARCHAR(64) NOT NULL,
	//  date_of_birth DATE NOT NULL,
	//  address_id VARCHAR(64),
	//  PRIMARY KEY (person_id),
	//  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)

}
