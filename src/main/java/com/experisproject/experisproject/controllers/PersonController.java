package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public Person getById(@PathVariable int id){
        return personService.findById(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createPerson(
            @RequestBody Map<String, Object> person
    ){
        System.out.println(person);
        //personService.save(person);
    }

}
