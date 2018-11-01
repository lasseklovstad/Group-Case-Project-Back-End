package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Integer> {

	Association findByName(String name);
	@Query(value = "SELECT a.associationId, a.name, a.description FROM Association a")
	List<Association> findAssociationsIdNameDescription();


}
