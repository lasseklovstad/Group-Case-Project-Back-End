package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Season {
	@Id
	@GeneratedValue
	private int seasonId;

	@NotNull private String name;
	@NotNull private LocalDate startDate;
	@NotNull private LocalDate endDate;
	private String description;

	/*  Unnecessary for now to map the entitities bidirectional
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
