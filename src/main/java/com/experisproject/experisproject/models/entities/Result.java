package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Result {
	@Id
	@GeneratedValue
	private int resultId;

	@NotNull
	private int score;

	@NotNull
	private String result;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "footballMatchId")
	private Math match;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public Result() {
	}

	public Result(@NotNull int score, @NotNull String result, Math match, Team team) {
		this.score = score;
		this.result = result;
		this.match = match;
		this.team = team;
	}
}
