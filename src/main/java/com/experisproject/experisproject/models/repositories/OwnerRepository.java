package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Owner;

import com.experisproject.experisproject.projections.OwnerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {

	@Query("SELECT o FROM Owner o")
	List<OwnerLimited> findAllLimited();
}
