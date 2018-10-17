package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Association {
	@Id
	@GeneratedValue
	private int associationId;

	private String name;
	private String description;

	@OneToMany(mappedBy = "association")
	private List<Team> teams;

	public Association() {
	}

}
