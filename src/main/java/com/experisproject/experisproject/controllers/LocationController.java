package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.models.forms.LocationForm;
import com.experisproject.experisproject.projections.LocationLimited;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "api/location")
@CrossOrigin
public class LocationController {
	@Autowired
	LocationService locationService;
	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Location> getLocationIdNameAndDescription() {
		return locationService.findLocationIdNameDescriptionAddress();
	}

	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	public List<LocationLimited> getAllLimited() {
		return locationService.findAllLimited();
	}

	@RequestMapping(value = "/{id}")
	public Location getLocation(@PathVariable int id) {
		Location location = locationService.findById(id);
		return location;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createNewLocation(@RequestBody LocationForm form, HttpServletResponse response) {
		try {
			Address address;
			address = addressService.findById(form.getAddressId());
			Location location = new Location(form.getName(), form.getDescription(), address);
			locationService.save(location);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteLocationById(@PathVariable int id, HttpServletResponse response) {

		try {
			locationService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		}
	}

	@RequestMapping(value = "delete/all", method = RequestMethod.DELETE)
	public void deleteAllLocations(HttpServletResponse response) {
		try {
			locationService.deleteAll();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		}

	}

}
