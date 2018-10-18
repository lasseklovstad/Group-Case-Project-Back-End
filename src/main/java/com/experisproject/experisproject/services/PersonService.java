package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Person;
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

    }

    public List<Person> findAll(){
        Iterable<Person> persons = this.repository.findAll();
        List<Person> result = new ArrayList<>();

        for (Person person : persons) {
            result.add(person);
        }

        return result;
    }
    public Person findById(Long id){
        return repository.findById(id).get();
    }
    public void save(Person person){
        repository.save(person);
    }
}
