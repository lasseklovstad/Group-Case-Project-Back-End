package com.experisproject.experisproject.models.forms;

import com.experisproject.experisproject.models.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class FootballMatchForm {

	private int footballMatchId;
	private int seasonId;
	private int locationId;
	private int homeTeamId;
	private int awayTeamId;
	private HashSet<Player> players;

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

	public HashSet<Player> getPlayers() {
		return players;
	}
}
