package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
	private Person person;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy = "player")
	private MatchPosition matchposition;

	@OneToMany(mappedBy = "player")
	private List<MatchGoal> matchGoals;
	*/

	public Player() {
	}

	public int getPlayerId() {
		return playerId;
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
