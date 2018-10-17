package com.experisproject.experisproject.models.entities;

import com.experisproject.experisproject.models.helpClasses.ResultId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(ResultId.class)
public class Result {

	@Id private int matchId; //to be checked and googled with helpclass
	@Id private int teamId;
	private int score;
	private String result;

	@ManyToOne
	@JoinColumn(name = "matchId", updatable = false, insertable = false)
	private FootballMatch footballMatch;

	@ManyToOne
	@JoinColumn(name = "teamId", updatable = false, insertable = false)
	private Team team;

	public Result() {
	}

	//  score INT NOT NULL,
	//  result VARCHAR(4) NOT NULL,
	//  match_id INT NOT NULL,
	//  team_id INT NOT NULL,
	//  PRIMARY KEY (match_id), lagt til teamId skal den ikke også ha team_id? tenker mer!
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),
	//  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)

}
