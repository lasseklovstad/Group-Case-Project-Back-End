package com.experisproject.experisproject.models.entities;

import javax.persistence.*;

@Entity
public class Coach {
	@Id
	@GeneratedValue
	private int coachId;

	//personId as foreign key, references Person(personId)
	//  coach_id INT NOT NULL,
	//  person_id INT NOT NULL,
	//  PRIMARY KEY (coach_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

	@OneToOne
	@MapsId("personID") //smør på flesk?
	@JoinColumn(name = "personId")
	private Person person;

	public Coach() {
	}
}
