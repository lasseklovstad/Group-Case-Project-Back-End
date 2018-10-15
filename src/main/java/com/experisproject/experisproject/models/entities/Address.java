package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
