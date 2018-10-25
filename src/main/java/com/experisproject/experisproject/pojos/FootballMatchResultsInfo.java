package com.experisproject.experisproject.pojos;

import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.entities.TeamResult;

import java.util.List;

public class FootballMatchResultsInfo {

	String homeTeam;
	String awayTeam;

	List<TeamResult> homeTeamResults;
	List<TeamResult> awayTeamResults;

	public FootballMatchResultsInfo(String homeTeam, String awayTeam, List<TeamResult> homeTeamResults, List<TeamResult> awayTeamResults) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamResults = homeTeamResults;
		this.awayTeamResults = awayTeamResults;
	}
}
