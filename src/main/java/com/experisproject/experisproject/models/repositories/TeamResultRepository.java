package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.TeamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TeamResultRepository extends JpaRepository<TeamResult, Integer> {

	@Query(value = "SELECT tr.teamResultId, tr.goals, tr.result, tr.footballMatch.footballMatchId, tr.team.teamId, tr.team.name  FROM TeamResult tr")
	List<TeamResult> findTeamResultsIdGoalsResultTeamIdName();

	@Query(value = "SELECT tr.teamResultId, tr.goals, tr.team.teamId, tr.team.name, tr.footballMatch.footballMatchId, tr.result, tr.footballMatch.homeTeam.name FROM TeamResult tr WHERE tr.footballMatch.footballMatchId = :footballMatchId")
	List<TeamResult> findTeamResultsByFootballMatchId(@Param("footballMatchId") int footballMatchId);

	@Query(value = "SELECT tr.footballMatch.footballMatchId, tr.footballMatch.matchDate, tr.team.teamId, tr.team.name, tr.footballMatch.location.locationId, tr.footballMatch.location.name, tr.goals, tr.result  FROM TeamResult tr WHERE tr.team.teamId = tr.footballMatch.homeTeam.teamId")
	List<TeamResult> findHomeTeamResults();

	@Query(value = "SELECT tr.footballMatch.footballMatchId, tr.footballMatch.matchDate, tr.team.teamId, tr.team.name, tr.footballMatch.location.locationId, tr.footballMatch.location.name, tr.goals, tr.result FROM TeamResult tr WHERE tr.team.teamId = tr.footballMatch.awayTeam.teamId")
	List<TeamResult> findAwayTeamResults();

}
