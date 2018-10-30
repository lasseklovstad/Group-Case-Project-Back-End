package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Watchlist {
	@Id
	@GeneratedValue
	private int watchlistId;

	private List<String> playerIds;

	private List<String> teamIds;

	@OneToOne
	@JoinColumn(name = "userId")
	@NotNull
	private User user;

	public Watchlist(List<String> playerIds, List<String> teamIds, @NotNull User user) {
		this.playerIds = playerIds;
		this.teamIds = teamIds;
		this.user = user;
	}

	public List<String> getPlayerIds() {
		return playerIds;
	}

	public List<String> getTeamIds() {
		return teamIds;
	}

	public User getUser() {
		return user;
	}

	public void setPlayerIds(List<String> playerIds) {
		this.playerIds = playerIds;
	}

	public void setTeamIds(List<String> teamIds) {
		this.teamIds = teamIds;
	}
}
