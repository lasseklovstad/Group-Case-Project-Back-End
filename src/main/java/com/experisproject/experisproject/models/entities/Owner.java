package com.experisproject.experisproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)//doesnt exist without owner
	@JsonIgnore
	private Team team;


	public Owner() {
	}

	public Owner(@NotNull Person person) {
		this.person = person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	// PRIMARY KEY (owner_id),
	// FOREIGN KEY (person_id) REFERENCES PERSON(person_id)

}
