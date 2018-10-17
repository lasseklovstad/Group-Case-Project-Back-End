package com.experisproject.experisproject.models.helpClasses;

import com.experisproject.experisproject.models.entities.Match;
import com.experisproject.experisproject.models.entities.Team;

public class ResultId {
	private int matchId;
	private int teamId;

	public ResultId() {
		Match match = new Match();
		Team team = new Team();
		this.matchId = match.getMatchId();
		this.teamId = team.getTeamId();
	}

}
