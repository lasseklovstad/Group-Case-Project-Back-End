package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class GoalType {
	@Id
	@GeneratedValue
	private int goalTypeId;

	@NotNull private String type;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToOne(mappedBy = "goalType")
	private MatchGoal matchGoal;
	*/

	public GoalType() {
	}

	public GoalType(@NotNull String type) {
		this.type = type;
	}
}
