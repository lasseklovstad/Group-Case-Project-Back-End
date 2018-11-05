package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Contact;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.forms.ContactForm;
import com.experisproject.experisproject.services.ContactService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/contact")
@CrossOrigin
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Contact> getContactsIdTypeDetailAndName() {
		return contactService.findContactsIdTypeDetailAndName();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Contact> getContactsAllInfo() {
		return contactService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Contact getContactById(@PathVariable int id, HttpServletResponse response) {
		return contactService.findById(id);
		//response.setStatus(HttpServletResponse.SC_OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createContact(@RequestBody ContactForm form, HttpServletResponse response) {
		try {
			Person person = personService.findById(form.getPersonId());
			Contact contact = new Contact(form.getContactType(), form.getContactDetail(), person);
			contactService.save(contact);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updateContact(@RequestBody ContactForm form, HttpServletResponse response) {
		try {
			Person person = personService.findById(form.getPersonId());
			Contact contact = contactService.findById(form.getPersonId());
			contact.setContactType(form.getContactType());
			contact.setContactDetail(form.getContactDetail());
			contact.setPerson(person);
			contactService.updateContact(contact);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}


	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteContactById(@PathVariable int id, HttpServletResponse response) {
		try {
			contactService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
