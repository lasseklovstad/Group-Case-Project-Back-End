package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.forms.TeamForm;
import com.experisproject.experisproject.projections.TeamLimited;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/team")
public class TeamController implements CommandLineRunner {

	@Autowired
	TeamService teamService;
	@Autowired
	OwnerService ownerService;
	@Autowired
	LocationService locationService;
	@Autowired
	CoachService coachService;
	@Autowired
	PersonService personService;
	@Autowired
	AddressService addressService;
	@Autowired
	AssociationService associationService;
	@Autowired
	PlayerService playerService;
	@Autowired
	UserService userService;


	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Team> getTeamsIdsNameCoachLocation() {
		return teamService.findTeamsIdsNameCoachLocation();
	}

	@RequestMapping(value = "/limitedInfo", method = RequestMethod.GET)
	public List<TeamLimited> getAllLimited() {
		return teamService.findAllLimited();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeamById(@PathVariable int id) {
		return teamService.findById(id);
	}

	@RequestMapping(value = "/getPlayersByTeamId/{id}", method = RequestMethod.GET)
	public List<Player> getPlayersByTeamId(@PathVariable int id) {
		return playerService.findPlayersByTeamId(id);
	}

	@RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
	public List<Team> getTeamsByName(@PathVariable String name) {
		return teamService.findAllByName(name);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createTeam(@RequestBody TeamForm form, HttpServletResponse response) {
		try {
			Association association = associationService.findById(form.getAssociationId());
			Owner owner = ownerService.findById(form.getOwnerId());
			Coach coach = coachService.findById(form.getCoachId());
			Location location = locationService.findById(form.getLocationId());

			Team team = new Team(form.getName(), association, owner, coach, location);
			teamService.save(team);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateTeam(@RequestBody TeamForm form, HttpServletResponse response) {
		try {
			Team team = teamService.findById(form.getTeamId());
			team.setName(form.getName());
			team.setAssociation(associationService.findById(form.getAssociationId()));
			team.setOwner(ownerService.findById(form.getOwnerId()));
			team.setCoach(coachService.findById(form.getCoachId()));
			team.setLocation(locationService.findById(form.getLocationId()));

			teamService.updateTeam(team);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex){
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	public void deleteTeamById(@PathVariable int id) {
		teamService.deleteById(id);
	}

	@Override
	public void run(String... args) throws Exception {
		//userService.deleteAll();
//       playerService.deleteAll();
//        teamService.deleteAll();
//        coachService.deleteAll();
//        ownerService.deleteAll();
//        locationService.deleteAll();
//        associationService.deleteAll();
//        personService.deleteAll();
//        addressService.deleteAll();


	}
}
