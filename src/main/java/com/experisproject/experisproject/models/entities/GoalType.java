package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class GoalType {
	@Id
	@GeneratedValue
	private Long goalTypeId;

	private String type;

	@OneToOne(mappedBy = "goaltype")
	private MatchGoal matchGoal;


	public GoalType() {
	}

}
