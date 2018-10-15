package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private Long addressId;

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private int postalCode;
	private String country;
}
