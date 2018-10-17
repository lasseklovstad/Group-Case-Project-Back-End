package com.experisproject.experisproject.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private int teamId;

	@OneToMany(mappedBy = "team")
	private List<Player> player;

	@ManyToOne
	@JoinColumn(name = "associationId")
	private Association association;

	@OneToMany(mappedBy = "team")
	private List<Match> matches; //check relation to Match (home and away team)

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	@OneToOne
	@JoinColumn(name = "coachId")
	private Coach coach;

	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;

	//  owner_id INT NOT NULL,
	//  association_id INT NOT NULL,
	//  coach_id INT NOT NULL,
	//  location_id INT NOT NULL,
	//  PRIMARY KEY (team_id),
	//  FOREIGN KEY (owner_id) REFERENCES OWNER(owner_id),
	//  FOREIGN KEY (association_id) REFERENCES ASSOCIATION(association_id),
	//  FOREIGN KEY (coach_id) REFERENCES COACH(coach_id),
	//  FOREIGN KEY (location_id) REFERENCES LOCATION(location_id)


	public Team() {
	}

	public int getTeamId() {
		return teamId;
	}
}
