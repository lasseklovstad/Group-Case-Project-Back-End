package com.experisproject.experisproject.models.entities;

import lombok.Data;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	private int userId;

	@NotNull
	@Column(unique = true)
	private String userName;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String password;
	@NotNull
	private boolean isAdmin;


	public User() {
	}

	public User(@NotNull String userName, @NotNull String email, @NotNull String password, @NotNull boolean isAdmin) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
}
