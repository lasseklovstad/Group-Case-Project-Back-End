package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}