package com.experisproject.experisproject.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
        this.repository.save(new Person("Lasse Kløvstad","lklov@gmail.com"));
        this.repository.save(new Person("Emil Kløvstad","ldsa@gmail.com"));
        this.repository.save(new Person("Ruth Kløvstad","lkldsaov@gmail.com"));
    }

    public List<Person> getAll(){
        Iterable<Person> persons = this.repository.findAll();
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            result.add(person);
        }

        return result;
    }

}
