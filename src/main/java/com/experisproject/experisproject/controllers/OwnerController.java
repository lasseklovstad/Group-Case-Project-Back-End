package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.forms.OwnerForm;
import com.experisproject.experisproject.projections.OwnerLimited;
import com.experisproject.experisproject.services.OwnerService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/owner")
@CrossOrigin
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<Owner> getAllOwners() {
		List<Owner> ownerList = ownerService.findAll();
		return ownerList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Owner getOwnerById(@PathVariable int id) {
		Owner owner = ownerService.findById(id);
		return owner;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Owner> getOwnersIdNameAndTeam() {
		return ownerService.findOwnersIdNameAndTeam();
	}


	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	public List<OwnerLimited> getOwnersLimitedInfo() {
		return ownerService.findAllLimited();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createOwner(@RequestBody OwnerForm form, HttpServletResponse response){
		try {
			Person person = personService.findById(form.getPersonId());
			Owner owner = new Owner(person);
			ownerService.save(owner);
			response.setStatus(HttpServletResponse.SC_CREATED);

		}catch (Exception ex){
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateOwner(@RequestBody OwnerForm form, HttpServletResponse response){
		try {
			Person person = personService.findById(form.getPersonId());
			personService.updatePerson(person);
			response.setStatus(HttpServletResponse.SC_OK);

		}catch (Exception ex){
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}



	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/



}
