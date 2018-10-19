package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@CrossOrigin
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


    @Override
    public void run(String... args) throws Exception {

        associationService.deleteAll();
        addressService.deleteAll();








//        Association association = new Association("NFF","blabla");
//        LocalDate bursdag = LocalDate.of(1992,10,17);
//        Address address = new Address("Soleveien 56","","","Sandefjord","3209","Norge");
//        Person person = new Person("Karoline","Rykkelid",bursdag,address);
//        associationService.save(association);
//        addressService.save(address);
//        personService.save(person);
//
//        Owner owner = new Owner(person);
//        Coach coach = new Coach(person);
//
//        ownerService.save(owner);
//        coachService.save(coach);
//
//        Location location = new Location("Stadio","fotball",address);
//        locationService.save(location);
//
//        Team team = new Team("Vålrenga",association,owner,coach,location,null);
//        teamService.save(team);
    }
}
