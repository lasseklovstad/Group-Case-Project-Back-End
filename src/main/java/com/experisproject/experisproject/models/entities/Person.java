package com.experisproject.experisproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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

	@OneToOne(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private Owner owner;

	@OneToOne(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private Coach coach;

	@OneToOne(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL) //if a person is deleted and is a player, no longer a player
	@JsonIgnore
	private Player player;

	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Contact> contacts;


	public Person() {
	}

	public Person(@NotNull String firstName, @NotNull String lastName, @NotNull LocalDate dateOfBirth, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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
