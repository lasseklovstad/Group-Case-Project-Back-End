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
//        associationService.deleteAll();
//        ownerService.deleteAll();
//        coachService.deleteAll();
//        personService.deleteAll();
//        locationService.deleteAll();
//        addressService.deleteAll();




//
//
//
//
//
//        Association association = new Association("NFF","Norges Fotballforbund (stiftet 30. april 1902) er et særidrettsforbund for fotball i Norge");
//        associationService.save(association);
//
//        LocalDate date = LocalDate.of(1967,2,10);
//        Address address = new Address("Karsevegen 50","","","Trondheim","7050","Norge");
//        Person person = new Person("Rini","Coolen",date,address);
//        addressService.save(address);
//        personService.save(person);
//        Coach coach = new Coach(person);
//        coachService.save(coach);
//
//        date = LocalDate.of(1959,8,22);
//        address = new Address("Karsevegen 50","","","Trondheim","7050","Norge");
//        person = new Person("Rini","Coolen",date,address);
//        addressService.save(address);
//        personService.save(person);
//        Owner owner = new Owner(person);
//        ownerService.save(owner);
//
//        address = new Address("Klæbuveien 125","","","Trondheim","7031","Norge");
//
//        Location location = new Location("Lerkendal Stadion","fotball",address);
//        locationService.save(location);
//
//        Team team = new Team("Rosenborg",association,owner,coach,location,null);
//        teamService.save(team);
    }
}
