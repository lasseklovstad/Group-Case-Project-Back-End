package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Season {
	@Id
	@GeneratedValue
	private int seasonId;

	@NotNull
	@Column(unique = true)
	private String name;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	private String description;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "season")
	private List<FootballMatch> footballMatches;
	*/

	public Season() {
	}

	public Season(@NotNull String name, @NotNull LocalDate startDate, @NotNull LocalDate endDate, String description) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
}
