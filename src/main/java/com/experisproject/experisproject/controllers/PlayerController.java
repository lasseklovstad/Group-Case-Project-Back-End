package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PersonService playerService;

    @RequestMapping(value="/all" , method=RequestMethod.GET)
    public void getall(){

    }

    @RequestMapping(value="/{id}" , method=RequestMethod.GET)
    public Player getById(@PathVariable int id){
        return new Player();
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public void create(){


        //playerService.save(person);
    }

}