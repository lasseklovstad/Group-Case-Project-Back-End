package com.experisproject.experisproject.models.helpClasses;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.entities.Team;

import java.io.Serializable;

public class ResultId implements Serializable {
	private int matchId;
	private int teamId;

	public ResultId() {
		FootballMatch footballMatch = new FootballMatch();
		Team team = new Team();
		this.matchId = footballMatch.getFootballMatchId();
		this.teamId = team.getTeamId();
	}

}
