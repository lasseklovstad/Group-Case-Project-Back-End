package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue
	private int addressId;

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private int postalCode;
	private String country;


	@OneToMany(mappedBy = "address")
	private List<Person> persons; //Set<Person> persons = new Hashmap

	@OneToOne(mappedBy = "address")
	private Location location;

	public Address() {
	}

}
