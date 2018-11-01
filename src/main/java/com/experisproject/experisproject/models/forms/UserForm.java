package com.experisproject.experisproject.models.forms;

public class UserForm {
	private int userId;

	private String userName;
	private String email;
	private String password;
	private boolean isAdmin;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}
}
