package com.experisproject.experisproject.models.entities;

import com.experisproject.experisproject.models.helpClasses.ResultId;

import javax.persistence.*;

@Entity
@IdClass(ResultId.class)
public class Result {

	@Id private int matchId; //to be checked and googled with helpclass
	@Id private int teamId;
	private int score;
	private String result;

	@ManyToOne
	@JoinColumn(name = "matchId")
	private Match match;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	//  score INT NOT NULL,
	//  result VARCHAR(4) NOT NULL,
	//  match_id INT NOT NULL,
	//  team_id INT NOT NULL,
	//  PRIMARY KEY (match_id), skal den ikke også ha team_id? tenker mer!
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),
	//  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)


}
