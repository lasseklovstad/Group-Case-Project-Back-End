package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Association {
	@Id
	@GeneratedValue
	private int associationId;

	@Column(unique = true)
	private String name;
	private String description;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "association")
	private List<Team> teams;*/

	public Association() {
	}

}
