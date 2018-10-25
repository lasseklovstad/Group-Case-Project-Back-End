package com.experisproject.experisproject.pojos;

import com.experisproject.experisproject.models.entities.Team;

public class FootballMatchResultsInfo {

	String homeTeam;
	String awayTeam;

	int homeTeamGoals;
	int awayTeamGoals;

	String homeTeamResult;
	String awayTeamResult;

	public FootballMatchResultsInfo(String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals, String homeTeamResult, String awayTeamResult) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamGoals = homeTeamGoals;
		this.awayTeamGoals = awayTeamGoals;
		this.homeTeamResult = homeTeamResult;
		this.awayTeamResult = awayTeamResult;
	}
}
