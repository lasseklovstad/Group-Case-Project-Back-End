package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
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

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Person> findAllOwners(){
		List<Person> ownerList = personService.findAll();
		return ownerList;

		//personOwnerList.add(personService.findPersonByOwner(ownerList.get(i)))
	}





/*
	@RequestMapping(value = "/{id}")
	public Owner findOwnerById(@PathVariable int id){
		Owner owner = ownerService.findOwnerByPersonId(id);
		return owner; //going to fix
	}
*/

}
