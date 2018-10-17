package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GoalType {
	@Id
	@GeneratedValue
	private Long goalTypeId;

	private String type;

	@OneToOne(mappedBy = "goaltype")
	private MatchGoal matchGoal;


	public GoalType() {
	}

	public GoalType(String type) {
		this.type = type;
	}
}
