package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.projections.CoachLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach,Integer> {

	@Query(value = "SELECT  c.coachId, CONCAT(c.person.firstName,' ',c.person.lastName), c.team.name FROM Coach c")
	List<Coach> findCoachesNameAndTeam();

	@Query(value = "SELECT c FROM Coach c")
	List<CoachLimited> findAllLimited();
}
