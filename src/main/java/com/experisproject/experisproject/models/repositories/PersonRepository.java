package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.PersonTest;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonTest,Long> {
}
