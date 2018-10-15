package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Season {
	@Id
	@GeneratedValue
	private Long seasonId;

	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	private String description;

}
