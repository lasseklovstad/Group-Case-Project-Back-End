package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.projections.OwnerLimited;
import com.experisproject.experisproject.services.OwnerService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/owner")
@CrossOrigin
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<Owner> getAllOwners(){
		List<Owner> ownerList = ownerService.findAll();
		return ownerList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Owner getOwnerById(@PathVariable int id){
		Owner owner = ownerService.findById(id);
		return owner;
	}

	@RequestMapping(value = "/all")
	public 	List<OwnerLimited> getOwnersLimitedInfo(){
		return ownerService.findAllLimited();
	}

}
