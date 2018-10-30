package com.experisproject.experisproject.models.forms;

public class LocationForm {

	private int locationId;
	private String name;
	private String description;
	private int addressId;


	public int getLocationId() {
		return locationId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAddressId() {
		return addressId;
	}

}

