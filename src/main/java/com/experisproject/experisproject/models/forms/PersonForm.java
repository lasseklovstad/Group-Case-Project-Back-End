package com.experisproject.experisproject.models.forms;

public class PersonForm {

	private int personId;

	private String firstName;
	private String lastName;

	//Date of birth
	private String date;


	private int addressId;

	public PersonForm() {
	}

	public int getPersonId() {
		return personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDate() {
		return date;
	}

	public int getAddressId() {
		return addressId;
	}
}
