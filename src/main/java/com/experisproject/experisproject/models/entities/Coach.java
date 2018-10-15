package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coach {
	@Id
	@GeneratedValue
	private int coachId;

	//personId as foreign key, references Person(personId)


	public Coach() {
	}
}
