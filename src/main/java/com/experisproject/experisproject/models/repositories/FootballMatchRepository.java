package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch, Integer> {
	
	@Query(value = "SELECT fm.footballMatchId, fm.matchDate,  fm.homeTeam.teamId, fm.homeTeam.name, fm.footballMatchId, fm.matchDate, fm.awayTeam.teamId, fm.awayTeam.name, fm.location.locationId, fm.location.name  FROM FootballMatch fm")
	List<FootballMatch> findFootballMatchIdDateSeasonLocationTeamsPlayers();


	//error
	@Query(value = "SELECT fm.homeTeam.name,fm.homeTeam.teamResults, fm.awayTeam.name, fm.awayTeam.teamResults FROM FootballMatch fm, TeamResult tr, Team t WHERE fm.footballMatchId = tr.footballMatch.footballMatchId AND fm.homeTeam.teamId = t.teamId AND fm.awayTeam.teamId = t.teamId")
	List<FootballMatch> findFootballMatchesResult();

	// new com.experisproject.experisproject.pojos.FootballMatchResultsInfo
}
