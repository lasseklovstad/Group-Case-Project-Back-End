package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Season {
	@Id
	@GeneratedValue
	private int seasonId;

	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String description;

	/*  Unnecessary for now to map the entitities bidirectional
	@OneToMany(mappedBy = "season")
	private List<FootballMatch> footballMatches;
	*/

	public Season() {
	}

}
