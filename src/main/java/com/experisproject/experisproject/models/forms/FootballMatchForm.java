package com.experisproject.experisproject.models.forms;

import java.util.ArrayList;

public class FootballMatchForm {

	private int footballMatchId;
	//matchDay
	private int year;
	private int month;
	private int day;

	private int seasonId;
	private int locationId;
	private int homeTeamId;
	private int awayTeamId;
	private ArrayList<String> playerIds;

	public int getFootballMatchId() {
		return footballMatchId;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
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
