package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
public class FavouriteList {

	@Id
	@GeneratedValue
	private int favouriteListId;

	private ArrayList<String> playerIds;
	private ArrayList<String> playerNames;

	private ArrayList<String> teamIds;
	private ArrayList<String> teamNames;

	@OneToOne
	@JoinColumn(name = "userId")
	@NotNull
	private Users users;

	public FavouriteList(ArrayList<String> playerIds, ArrayList<String> playerNames, ArrayList<String> teamIds, ArrayList<String> teamNames, @NotNull Users users) {
		this.playerIds = playerIds;
		this.playerNames = playerNames;
		this.teamIds = teamIds;
		this.teamNames = teamNames;
		this.users = users;
	}

	public ArrayList<String> getPlayerNames() {
		return playerNames;
	}

	public void setPlayerNames(ArrayList<String> playerNames) {
		this.playerNames = playerNames;
	}

	public ArrayList<String> getTeamNames() {
		return teamNames;
	}

	public void setTeamNames(ArrayList<String> teamNames) {
		this.teamNames = teamNames;
	}

	public ArrayList<String> getPlayerIds() {
		return playerIds;
	}

	public ArrayList<String> getTeamIds() {
		return teamIds;
	}

	public Users getUsers() {
		return users;
	}

	public void setPlayerIds(ArrayList<String> playerIds) {
		this.playerIds = playerIds;
	}

	public void setTeamIds(ArrayList<String> teamIds) {
		this.teamIds = teamIds;
	}
}
