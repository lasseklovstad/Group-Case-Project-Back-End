package com.experisproject.experisproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;

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

	@OneToOne(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Watchlist watchlist;

	public User() {
	}

	public User(@NotNull String userName, @NotNull String email, @NotNull String password, @NotNull boolean isAdmin) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}
}
