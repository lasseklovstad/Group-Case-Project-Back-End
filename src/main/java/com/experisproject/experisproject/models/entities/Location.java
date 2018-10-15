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
	// location_id INT NOT NULL,
	//  name VARCHAR(64) NOT NULL,
	//  description VARCHAR(64),
	//  address_id VARCHAR(64) NOT NULL,
	//  PRIMARY KEY (location_id),
	//  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)

	public Location() {
	}

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
	}
}