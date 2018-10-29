package com.experisproject.experisproject.models.forms;

public class PlayerForm {

	private String number;
	private String normalPosition;
	private int personId;
	private int teamId;

	public String getNumber() {
		return number;
	}

	public String getNormalPosition() {
		return normalPosition;
	}

	public int getPersonId() {
		return personId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setNormalPosition(String normalPosition) {
		this.normalPosition = normalPosition;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
}
