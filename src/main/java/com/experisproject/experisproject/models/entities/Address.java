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

	/* Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "address")
	private List<Person> persons;

	@OneToOne(mappedBy = "address")
	private Location location;
	*/

	public Address() {
	}

	public Address(String addressLine1, String addressLine2, String addressLine3, int postalCode, String country) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.postalCode = postalCode;
		this.country = country;
	}
}
