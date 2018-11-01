package com.experisproject.experisproject.models.forms;

import java.util.ArrayList;

public class FootballMatchForm {

	private int footballMatchId;
	//matchDay
	private String date;
	private int seasonId;
	private int locationId;
	private int homeTeamId;
	private int awayTeamId;
	private ArrayList<String> playerIds;

	public String getDate() {
		return date;
	}

	public int getFootballMatchId() {
		return footballMatchId;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public int getLocationId() {
		return locationId;
	}

	public int getHomeTeamId() {
		return homeTeamId;
	}

	public int getAwayTeamId() {
		return awayTeamId;
	}

	public ArrayList<String> getPlayerIds() {
		return playerIds;
	}
}
