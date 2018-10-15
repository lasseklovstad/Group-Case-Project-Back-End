package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Association {
	@Id
	@GeneratedValue
	private Long associationId;

	private String name;
	private String description;

	public Association() {
	}
}
