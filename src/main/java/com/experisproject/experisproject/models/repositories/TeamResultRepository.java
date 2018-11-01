package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.TeamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TeamResultRepository extends JpaRepository<TeamResult, Integer> {

	@Query(value = "SELECT tr.teamResultId, tr.goals, tr.result, tr.footballMatch.footballMatchId, tr.team.teamId, tr.team.name  FROM TeamResult tr")
	List<TeamResult> findTeamResultsIdGoalsResultTeamIdName();

}
