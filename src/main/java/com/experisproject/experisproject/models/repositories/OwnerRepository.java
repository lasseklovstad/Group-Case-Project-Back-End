package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {

	List<Owner> findByPerson(Person person);
}
