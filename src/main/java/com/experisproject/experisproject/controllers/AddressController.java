package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Address> getAllAddressInfo() {
		return addressService.findAddressesInfo();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Address getAddressById(@PathVariable int id) {
		return addressService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createNewAddress(@RequestBody Address address, HttpServletResponse response){
		try {
			addressService.save(address);
			response.setStatus(HttpServletResponse.SC_CREATED);

		}catch (Exception e){
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateAddress(@RequestBody Address address, HttpServletResponse response){
		try {
			addressService.updateAddress(address);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch (Exception e){
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
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
