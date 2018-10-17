package com.experisproject.experisproject.models.helpClasses;

import com.experisproject.experisproject.models.entities.Match;
import com.experisproject.experisproject.models.entities.Player;

import java.io.Serializable;

public class MatchPositionId implements Serializable {
	private int matchId;
	private int playerId;

	public MatchPositionId() {
		Match match = new Match();
		Player player = new Player();
		this.matchId = match.getMatchId();
		this.playerId = player.getPlayerId();
	}
}
