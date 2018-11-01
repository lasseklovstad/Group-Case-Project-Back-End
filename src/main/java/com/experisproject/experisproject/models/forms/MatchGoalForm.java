package com.experisproject.experisproject.models.forms;

public class MatchGoalForm {

	private int matchGoalId;
	private String description;
	private int goalTypeId;
	private int footballMatchId;
	private int playerId;

	public int getMatchGoalId() {
		return matchGoalId;
	}

	public String getDescription() {
		return description;
	}

	public int getGoalTypeId() {
		return goalTypeId;
	}

	public int getFootballMatchId() {
		return footballMatchId;
	}

	public int getPlayerId() {
		return playerId;
	}
}
