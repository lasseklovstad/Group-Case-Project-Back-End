package com.experisproject.experisproject.models.forms;

public class PersonForm {
	private String firstName;
	private String lastName;

	//Date of birth
	private int year;
	private int month;
	private int day;

	private int addressId;


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getAddressId() {
		return addressId;
	}
}
