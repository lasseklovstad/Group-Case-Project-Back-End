package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class TeamResult {
	@Id
	@GeneratedValue
	private int teamResultId;

	@NotNull
	private int goals;

	@NotNull
	private String result;

	@ManyToOne
	@JoinColumn(name = "footballMatchId")
	private FootballMatch footballMatch;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public TeamResult() {
	}

	public TeamResult(@NotNull int goals, @NotNull String result, FootballMatch footballMatch, Team team) {
		this.goals = goals;
		this.result = result;
		this.footballMatch = footballMatch;
		this.team = team;
	}

	public int getTeamResultId() {
		return teamResultId;
	}

	public FootballMatch getFootballMatch() {
		return footballMatch;
	}

	public Team getTeam() {
		return team;
	}

	public int getGoals() {
		return goals;
	}

	public String getResult() {
		return result;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setFootballMatch(FootballMatch footballMatch) {
		this.footballMatch = footballMatch;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
