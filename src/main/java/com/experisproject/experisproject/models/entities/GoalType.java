package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GoalType {
	@Id
	@GeneratedValue
	private Long goalTypeId;

	private String type;

	public GoalType() {
	}

	public GoalType(String type) {
		this.type = type;
	}
}
