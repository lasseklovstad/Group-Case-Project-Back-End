package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.projections.TeamLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	List<Team> findAllByNameContaining(String name);

	@Query(value = "SELECT  t.teamId, t.name, t.coach.coachId, CONCAT(t.coach.person.firstName,' ',t.coach.person.lastName), t.location.locationId, t.location.name, t.location.address.country FROM Team t")
	List<Team> findTeamsIdsNameCoachLocation();

	@Query(value = "SELECT team FROM Team team")
	List<TeamLimited> findAllRemodelTeams();

}
