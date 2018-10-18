package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Association {
	@Id
	@GeneratedValue
	private int associationId;

	@Column(unique = true)
	@NotNull private String name;
	@NotNull private String description;

	/*  Unnecessary for now to map the entities bidirectional
	@OneToMany(mappedBy = "association")
	private List<Team> teams;*/

	public Association() {
	}

	public Association(@NotNull String name, @NotNull String description) {
		this.name = name;
		this.description = description;
	}
}
