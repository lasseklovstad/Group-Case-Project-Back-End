package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue
	private int teamId;

	@Column(unique = true)
	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name = "associationId")
	@NotNull
	private Association association;

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	@OneToOne
	@JoinColumn(name = "coachId")
	@NotNull
	private Coach coach;

	@OneToOne
	@JoinColumn(name = "locationId")
	@NotNull
	private Location location;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "team")
	private List<Player> players;
	@OneToMany(mappedBy = "homeTeam")
	private List<FootballMatch> homeFootballMatches;
	@OneToMany(mappedBy = "awayTeam")
	private List<FootballMatch> awayFootballMatches;
	*/

	public Team() {
	}

	public Team(@NotNull String name, @NotNull Association association, Owner owner, @NotNull Coach coach, @NotNull Location location) {
		this.name = name;
		this.association = association;
		this.owner = owner;
		this.coach = coach;
		this.location = location;
	}

	//  owner_id INT NOT NULL,
	//  association_id INT NOT NULL,
	//  coach_id INT NOT NULL,
	//  location_id INT NOT NULL,
	//  PRIMARY KEY (team_id),
	//  FOREIGN KEY (owner_id) REFERENCES OWNER(owner_id),
	//  FOREIGN KEY (association_id) REFERENCES ASSOCIATION(association_id),
	//  FOREIGN KEY (coach_id) REFERENCES COACH(coach_id),
	//  FOREIGN KEY (location_id) REFERENCES LOCATION(location_id)

}
