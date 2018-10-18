package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Player {
	@Id
	@GeneratedValue
	private int playerId;

	private String number;
	private String normalPosition;

	@OneToOne
	@JoinColumn(name = "personId")
	@NotNull
	private Person person;

	@ManyToOne
	@JoinColumn(name = "teamId")
	@NotNull
	private Team team;

	@ManyToMany(mappedBy = "players") //NotNull annotation???
	private Set<FootballMatch> footballMatches = new HashSet<>();

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "player")
	private List<MatchGoal> matchGoals;
	*/

	public Player() {
	}

	public Player(String number, String normalPosition, @NotNull Person person, @NotNull Team team, Set<FootballMatch> footballMatches) {
		this.number = number;
		this.normalPosition = normalPosition;
		this.person = person;
		this.team = team;
		this.footballMatches = footballMatches;
	}

//  player_id INT NOT NULL,
	//  normal_position VARCHAR(64),
	//  number VARCHAR(8), (int????)
	//  person_id INT NOT NULL,
	//  team_id INT NOT NULL,
	//  PRIMARY KEY (player_id),
	//  FOREIGN KEY (person_id) REFERENCES PERSON(person_id),
	//  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)
}
