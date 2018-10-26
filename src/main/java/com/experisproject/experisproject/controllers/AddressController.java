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
		return addressService.findAddressesShortInfo();
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

}
