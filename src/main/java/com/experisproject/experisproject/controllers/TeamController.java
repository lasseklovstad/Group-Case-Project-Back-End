package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Team> getAll(){
        return teamService.findAll();
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
