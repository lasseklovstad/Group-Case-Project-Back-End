package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.repositories.AddressRepository;
import com.experisproject.experisproject.models.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements CommandLineRunner {

	private PersonRepository personRepository;

	@Autowired
	public PersonRepository personRepository(PersonRepository personRepository) {
		return this.personRepository = personRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//personRepository.deleteAll();
		//addressRepository.deleteAll();
	}

	public Person findPersonByOwner(Owner owner) {
		return personRepository.findPersonByOwner(owner);
	}

	public List<Person> findPersonsIdName() {
		return personRepository.findPersonsIdName();
	}

	public List<Person> findAll() {
		List<Person> result = new ArrayList<>();
		personRepository.findAll().forEach(person -> result.add(person));
		return result;
	}

	public Person findById(int id) {
		return personRepository.findById(id).get();
	}

	public void updatePerson(Person person) {
		personRepository.save(person);
	}

	public void save(Person person) {
		personRepository.save(person);
	}

	public void deleteById(int id) {
		personRepository.deleteById(id);
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}
}
