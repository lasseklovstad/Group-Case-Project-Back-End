package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Address> getAllAddressInfo() {
		return addressService.findAddressesInfo();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Address getAddressById(@PathVariable int id) {
		return addressService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createAddress(@RequestBody Address address, HttpServletResponse response){
		try {
			addressService.save(address);
			response.setStatus(HttpServletResponse.SC_CREATED);

		}catch (Exception e){
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updateAddress(@RequestBody Address address, HttpServletResponse response){
		try {//if exists? works automatic
			addressService.updateAddress(address);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch (Exception e){
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}



	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAddressById(@PathVariable int id, HttpServletResponse response){
		try {
			addressService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		}

	}
}
