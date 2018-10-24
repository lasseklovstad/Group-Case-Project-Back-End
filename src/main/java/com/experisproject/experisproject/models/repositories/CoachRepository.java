package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.projections.CoachLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach,Integer> {


	@Query(value = "SELECT c FROM Coach c")
	List<CoachLimited> findAllLimited();
}
