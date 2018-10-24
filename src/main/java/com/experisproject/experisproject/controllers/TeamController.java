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
@RequestMapping(value = "api/teams")
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


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<TeamLimited> getAll(){
        return teamService.findAllLimited();

    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<String> getAllNames(){
        return teamService.findAllNames();
    }

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public List<Team> getTeamsByName(@PathVariable String name){
        return teamService.findAllByName(name);
    }

    @Override
    public void run(String... args) throws Exception {
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
