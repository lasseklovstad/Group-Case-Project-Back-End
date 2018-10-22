package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue
	private Long locationId;

	@NotNull
	@Column(unique = true)
	private String name;
	private String description;

	@OneToOne
	@JoinColumn(name = "addressId")
	@NotNull
	private Address address;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "location")
	private List<FootballMatch> footballMatches;
	@OneToOne(mappedBy = "location")
	private Team team;
	*/

	public Location() {
	}

	public Location(@NotNull String name, String description, @NotNull Address address) {
		this.name = name;
		this.description = description;
		this.address = address;
	}

	//  foreign key Address.addressId
	//  location_id INT NOT NULL,
	//  name VARCHAR(64) NOT NULL,
	//  description VARCHAR(64),
	//  address_id VARCHAR(64) NOT NULL,
	//  PRIMARY KEY (location_id),
	//  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)

}