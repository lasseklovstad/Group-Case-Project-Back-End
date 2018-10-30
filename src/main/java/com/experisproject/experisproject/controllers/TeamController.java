package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.projections.TeamLimited;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;

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
		Team team = teamService.findById(id);
		return team;
	}

	@RequestMapping(value="/getPlayersByTeamId/{id}",method = RequestMethod.GET)
	public List<Player> getPlayersByTeamId(@PathVariable int id){
		return playerService.getPlayersByTeamId(id);
	}

	@RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
	public List<Team> getTeamsByName(@PathVariable String name) {
		return teamService.findAllByName(name);
	}

	@Override
	public void run(String... args) throws Exception {
		//userService.deleteAll();
//        playerService.deleteAll();
//        teamService.deleteAll();
//        coachService.deleteAll();
//        ownerService.deleteAll();
//        locationService.deleteAll();
//        associationService.deleteAll();
//        personService.deleteAll();
//        addressService.deleteAll();


	}
}
