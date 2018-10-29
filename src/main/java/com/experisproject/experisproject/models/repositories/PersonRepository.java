package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Owner;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.projections.PersonLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	Person findPersonByOwner(Owner owner);

	@Query(value = "SELECT p.personId, CONCAT(p.firstName,' ', p.lastName) FROM Person p")
	List<Person> findPersonsIdName();

	@Query(value = "SELECT p FROM Person p")
	List<PersonLimited> findAllLimited();
}

