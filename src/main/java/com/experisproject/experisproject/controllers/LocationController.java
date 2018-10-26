package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.models.forms.AssociationForm;
import com.experisproject.experisproject.projections.LocationLimited;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
	public void createNewLocation(@RequestBody AssociationForm form, HttpServletResponse response){
		try{
			Address address;
			address = addressService.findById(form.getAddressId());
			Location location = new Location(form.getName(),form.getDescription(),address);
			locationService.save(location);
			response.setStatus(HttpStatus.OK.value());
		}
		catch (Exception e){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
