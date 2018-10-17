package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue
	private int teamId;

	@OneToMany(mappedBy = "team")
	private List<Player> players;

	@ManyToOne
	@JoinColumn(name = "associationId")
	private Association association;

	@OneToMany(mappedBy = "homeTeam")
	private List<Match> homeMatches;

	@OneToMany(mappedBy = "awayTeam")
	private List<Match> awayMatches;

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	@OneToOne
	@JoinColumn(name = "coachId")
	private Coach coach;

	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;

	public Team() {
	}

	public int getTeamId() {
		return teamId;
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
