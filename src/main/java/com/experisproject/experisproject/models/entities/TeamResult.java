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

	@ManyToOne(cascade = CascadeType.ALL)
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
}
