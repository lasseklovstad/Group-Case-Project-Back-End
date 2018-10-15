package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.services.PersonService;
import com.experisproject.experisproject.models.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private PersonService personService;

    @CrossOrigin(origins = "localhost:3000")
    @RequestMapping(value = "/person")
    public Person getAll(){
        return personService.getAll().get(0);
    }

}
