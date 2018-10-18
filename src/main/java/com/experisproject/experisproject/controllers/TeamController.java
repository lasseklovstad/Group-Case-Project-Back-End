package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.services.TeamService;
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


    @Override
    public void run(String... args) throws Exception {
        Association association = new Association();
        LocalDate bursdag = LocalDate.of(1992,10,17);
        Address address = new Address("Soleveien 56","","","Sandefjord","3209","Norge");
        Person person = new Person("Karoline","Rykkelid",bursdag,address);

        Owner owner = new Owner(person);
        Coach coach = new Coach(person);
    }
}
