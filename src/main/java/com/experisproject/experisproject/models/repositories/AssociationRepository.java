package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AssociationRepository extends JpaRepository<Association, Integer> {


	@Query(value = "SELECT a.associationId, a.name, a.description FROM Association a")
	List<Association> findAssociationsIdNameDescription();


}
