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




	public void setFootballMatchId(int footballMatchId) {
		this.footballMatchId = footballMatchId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public void setPlayerIds(ArrayList<String> playerIds) {
		this.playerIds = playerIds;
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
