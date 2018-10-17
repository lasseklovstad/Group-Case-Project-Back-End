package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MatchGoal {
	@Id
	@GeneratedValue
	private int matchGoalId;
	private String description;

	@OneToOne
	@JoinColumn(name = "goalTypeId")
	private GoalType goalType;

	@ManyToOne
	@JoinColumn(name = "matchId")
	private FootballMatch footballMatch;

	@ManyToOne
	@JoinColumn(name = "playerId")
	private Player player;

	public MatchGoal() {
	}

	// goal_id INT NOT NULL,
	//  description VARCHAR(64),
	//  goal_type_id INT NOT NULL,
	//  match_id INT NOT NULL,
	//  player_id INT NOT NULL,
	//  PRIMARY KEY (goal_id),
	//  FOREIGN KEY (goal_type_id) REFERENCES GOAL_TYPE(goal_type_id),
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),
	//  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id)

}
