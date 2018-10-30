package com.experisproject.experisproject.models.forms;

import java.util.ArrayList;

public class WatchlistForm {
	private int watchlistId;
	private ArrayList<String> playerIds;
	private ArrayList<String> teamIds;
	private int userId;

	public int getWatchlistId() {
		return watchlistId;
	}

	public ArrayList<String> getPlayerIds() {
		return playerIds;
	}

	public void setPlayerIds(ArrayList<String> playerIds) {
		this.playerIds = playerIds;
	}

	public ArrayList<String> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(ArrayList<String> teamIds) {
		this.teamIds = teamIds;
	}

	public int getUserId() {
		return userId;
	}
}
