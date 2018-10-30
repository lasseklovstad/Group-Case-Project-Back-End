package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.forms.CoachForm;
import com.experisproject.experisproject.projections.CoachLimited;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.CoachService;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/coach")
@CrossOrigin
public class CoachController {

	@Autowired
	private CoachService coachService;
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<Coach> getAllCoaches() {
		return coachService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Coach> getCoachesIdNameAndTeam() {
		return coachService.findCoachesIdNameAndTeam();
	}

	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	public List<CoachLimited> getCoachesLimitedInfo() {
		return coachService.findAllLimited();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Coach getCoachById(@PathVariable int id) {
		Coach coach = coachService.findById(id);
		return coach;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createCoach(@RequestBody CoachForm form, HttpServletResponse response) {
		try {
			Person person = personService.findById(form.getPersonId());
			Coach coach = new Coach(person);
			coachService.save(coach);
			response.setStatus(HttpServletResponse.SC_CREATED);

		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateCoach(@RequestBody CoachForm form, HttpServletResponse response) {
		try {
			//does it make any sense to do this???
			Person person = personService.findById(form.getPersonId());
			personService.updatePerson(person);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}


	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteCoachById(@PathVariable int id, HttpServletResponse response) {
		try {
			coachService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		}
	}
}
