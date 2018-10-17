package com.experisproject.experisproject.models.helpClasses;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.entities.Player;

import java.io.Serializable;

public class MatchPositionId implements Serializable {
	private int matchId;
	private int playerId;

	public MatchPositionId() {
		FootballMatch footballMatch = new FootballMatch();
		Player player = new Player();
		this.matchId = footballMatch.getFootballMatchId();
		this.playerId = player.getPlayerId();
	}
}
