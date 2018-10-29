package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.forms.PersonForm;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/person")
@CrossOrigin
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Person> getPersonsIdAndName() {
		return personService.findPersonsIdName();
	}

	@RequestMapping(value = "allInfo", method = RequestMethod.GET)
	public List<Person> getPersonsAllInfo(){
		return personService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getById(@PathVariable int id) {
		return personService.findById(id);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createPerson(@RequestBody PersonForm form, HttpServletResponse response){
		try {
			Address address = addressService.findById(form.getAddressId());
			LocalDate dateOfBirth = LocalDate.of(form.getYear(), form.getMonth(), form.getDay());
			Person person = new Person(form.getFirstName(), form.getLastName(),dateOfBirth, address);
			personService.save(person);
			response.setStatus(HttpServletResponse.SC_CREATED);
		}catch (Exception ex){
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updatePerson(@RequestBody PersonForm form, HttpServletResponse response){
		//almost exactly the same as create method createPerson(form,response)
		try {
			Address address = addressService.findById(form.getAddressId());
			LocalDate dateOfBirth = LocalDate.of(form.getYear(), form.getMonth(), form.getDay());
			Person person = new Person(form.getFirstName(), form.getLastName(), dateOfBirth, address);
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
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deletePersonById(@PathVariable int id, HttpServletResponse response) {
		try {
			personService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}



}
