package com.experisproject.experisproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TeamResult> teamResults;
/*
	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private List<Player> players;
	@OneToMany(mappedBy = "homeTeam")
	@JsonIgnore
	private List<FootballMatch> homeFootballMatches;
	@OneToMany(mappedBy = "awayTeam")
	@JsonIgnore
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

	public void setName(String name) {
		this.name = name;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setTeamResults(List<TeamResult> teamResults) {
		this.teamResults = teamResults;
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
