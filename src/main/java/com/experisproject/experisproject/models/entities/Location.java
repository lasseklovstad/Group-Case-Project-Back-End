package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long locationId;

	private String name;
	private String description;
	//foreign key Address.addressId


	public Location() {
	}

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
	}
}