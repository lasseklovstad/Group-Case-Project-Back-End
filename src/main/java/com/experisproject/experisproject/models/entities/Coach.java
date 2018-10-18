package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Coach {
	@Id
	@GeneratedValue
	private int coachId;

	@OneToOne
	@JoinColumn(name = "personId")
	@NotNull
	private Person person;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy = "coach")
	private Team team;*/

	public Coach() {
	}

	public Coach(@NotNull Person person) {
		this.person = person;
	}
	//personId as foreign key, references Person(personId)
	//  coach_id INT NOT NULL,
	//  person_id INT NOT NULL,
	//  PRIMARY KEY (coach_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

}
