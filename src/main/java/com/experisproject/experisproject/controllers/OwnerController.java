package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.services.OwnerService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/owner")
@CrossOrigin
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public void getAll(){
	//	List<Owner> ownerList = ownerService.findAll();

	}

	@RequestMapping(value = "/{id}")
	public Person getOwnerById(@PathVariable int id){
		//Owner owner = ownerService.findById(id);
		return new Person(); //going to fix
	}


}
