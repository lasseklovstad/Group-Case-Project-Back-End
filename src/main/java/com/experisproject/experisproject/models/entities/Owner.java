package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Owner {
	@Id
	@GeneratedValue
	private int ownerId;

	@OneToOne
	@JoinColumn(name = "personId")
	@NotNull
	private Person person;

	/* Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)//doesnt exist without owner
	private Team team;
	*/

	public Owner() {
	}

	public Owner(@NotNull Person person) {
		this.person = person;
	}

	// PRIMARY KEY (owner_id),
	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

}
