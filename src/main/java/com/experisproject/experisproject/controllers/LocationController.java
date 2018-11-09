package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.models.forms.LocationForm;
import com.experisproject.experisproject.projections.LocationLimited;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Location> getLocationIdNameAndDescription() {
		return locationService.findLocationIdNameDescriptionAddress();
	}

	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<LocationLimited> getAllLimited() {
		return locationService.findAllLimited();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Location getLocation(@PathVariable int id) {
		return locationService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createLocation(@RequestBody LocationForm form, HttpServletResponse response) {
		try {
			Address address = addressService.findById(form.getAddressId());
			Location location = new Location(form.getName(), form.getDescription(), address);
			locationService.save(location);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updateLocation(@RequestBody LocationForm form, HttpServletResponse response) {
		try {
			Address address = addressService.findById(form.getAddressId());
			Location location = locationService.findById(form.getLocationId());
			location.setName(form.getName());
			location.setDescription(form.getDescription());
			location.setAddress(address);
			locationService.updateLocation(location); //save(location) is called in service class
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}



	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteLocationById(@PathVariable int id, HttpServletResponse response) {
		try {
			locationService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		}
		catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/all/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
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
