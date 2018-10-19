package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.forms.PlayerForm;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.PersonService;
import com.experisproject.experisproject.services.PlayerService;
import com.experisproject.experisproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;


@RestController
@RequestMapping(value="/api/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private TeamService teamService;

    @RequestMapping(value="/all" , method=RequestMethod.GET)
    public void getAll(HttpServletRequest req,HttpServletResponse res){

    }

    @RequestMapping(value="/{id}" , method=RequestMethod.GET)
    public Player getById(@PathVariable int id){
        return new Player();
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void create(
            @RequestBody PlayerForm form,
            HttpServletResponse response
    ){

        //Create new player
        Address address = new Address(form.getAddressLine1(),form.getAddressLine2(),form.getAddressLine3(),form.getCity(),form.getPostalCode(),form.getCountry());
        LocalDate dateOfBirth = LocalDate.of(form.getYear(),form.getMonth(),form.getDay());
        Person person = new Person(form.getFirstName(),form.getLastName(),dateOfBirth,address);
        Team team = new Team();
        Player player = new Player(form.getNumber(),form.getNormalPosition(),person,team,null);

        teamService.save(team);
        addressService.save(address);
        personService.save(person);
        playerService.save(player);
        //playerService.save(person);
        response.setStatus(HttpStatus.OK.value());
    }

}