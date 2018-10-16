package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {

	@Id
	private int matchId;

	private int score;
	private String result;

	//  score INT NOT NULL,
	//  result VARCHAR(4) NOT NULL,
	//  match_id INT NOT NULL,
	//  team_id INT NOT NULL,
	//  PRIMARY KEY (match_id), skal den ikke også ha team_id? tenker mer!
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),
	//  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)


}
