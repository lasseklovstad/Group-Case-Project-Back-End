package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Owner;

import com.experisproject.experisproject.projections.OwnerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	@Query(value = "SELECT  o.ownerId, CONCAT(o.person.firstName,' ',o.person.lastName), o.team.teamId, o.team.name FROM Owner o")
	List<Owner> findOwnersIdNameAndTeam();

	@Query("SELECT o FROM Owner o")
	List<OwnerLimited> findAllLimited();
}
