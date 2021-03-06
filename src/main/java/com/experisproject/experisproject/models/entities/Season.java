package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Season {
	@Id
	@GeneratedValue
	private int seasonId;

	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	private String description;

	public Season() {
	}

	public Season(LocalDate startDate, LocalDate endDate, String name, String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.description = description;
	}
}
