package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/all" , method=RequestMethod.GET)
    public List<Person> getall(){
        List<Person> personList = personService.findAll();
        return personList;
    }

    @RequestMapping(value="/{id}" , method=RequestMethod.GET)
    public Person getById(@PathVariable Long id){
        return personService.findById(id);
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public void createPerson(@RequestParam(value = "person") Person person){
        personService.save(person);
    }

}
