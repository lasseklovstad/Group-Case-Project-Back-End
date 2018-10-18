package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Owner {
	@Id
	@GeneratedValue
	private int ownerId;

	@OneToOne
	@JoinColumn(name = "personId")
	private Person person;

	/* Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)//doesnt exist without owner
	private Team team;
	*/

	public Owner() {
	}

	// PRIMARY KEY (owner_id),
	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

}
