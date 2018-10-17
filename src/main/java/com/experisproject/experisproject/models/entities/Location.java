package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue
	private Long locationId;

	private String name;
	private String description;

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToMany(mappedBy = "location")
	private List<Match> matches;

	@OneToOne(mappedBy = "location")
	private Team team;

	public Location() {
	}

	//  foreign key Address.addressId
	//  location_id INT NOT NULL,
	//  name VARCHAR(64) NOT NULL,
	//  description VARCHAR(64),
	//  address_id VARCHAR(64) NOT NULL,
	//  PRIMARY KEY (location_id),
	//  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)

}