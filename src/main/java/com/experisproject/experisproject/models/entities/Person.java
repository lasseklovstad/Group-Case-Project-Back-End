package com.experisproject.experisproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue
	private int personId;

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private LocalDate dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	@JsonIgnore
	private Owner owner;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	@JsonIgnore
	private Coach coach;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy ="person", cascade = CascadeType.ALL)//if a person is deleted and is a coach, no longer a coach
	private Coach coach;
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL) //if a person is deleted and is a player, no longer a player
	private Player player;
	@OneToOne(mappedBy = "person")
	private Contact contact;

	*/

	public Person() {
	}

	public Person(@NotNull String firstName, @NotNull String lastName, @NotNull LocalDate dateOfBirth, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
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
