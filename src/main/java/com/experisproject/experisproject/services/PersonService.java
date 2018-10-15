package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.PersonTest;
import com.experisproject.experisproject.models.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements CommandLineRunner {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository=repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new PersonTest("Lasse Kløvstad","lklov@gmail.com"));
        this.repository.save(new PersonTest("Emil Kløvstad","ldsa@gmail.com"));
        this.repository.save(new PersonTest("Ruth Kløvstad","lkldsaov@gmail.com"));
    }

    public List<PersonTest> getAll(){
        Iterable<PersonTest> persons = this.repository.findAll();
        List<PersonTest> result = new ArrayList<>();
        for (PersonTest person : persons) {
            result.add(person);
        }

        return result;
    }

}
