package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Season {
	@Id
	@GeneratedValue
	private int seasonId;

	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	private String description;

	@OneToMany(mappedBy = "season")
	private List<Match> matches;

	public Season() {
	}

	public Season(LocalDate startDate, LocalDate endDate, String name, String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.description = description;
	}
}
