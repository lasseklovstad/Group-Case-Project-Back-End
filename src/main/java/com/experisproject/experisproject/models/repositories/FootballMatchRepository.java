package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.pojos.FootballMatchResultsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch, Integer> {

	@Query(value = "SELECT fm.location.locationId, fm.location.name, fm.homeTeam.teamId, fm.homeTeam.name, fm.footballMatchId, fm.matchDate, fm.awayTeam.teamId, fm.awayTeam.name, fm.season.seasonId, fm.season.name   FROM FootballMatch fm")
	List<FootballMatch> findFootballMatchIdDateSeasonLocationTeamsPlayers();

	@Query(value = "SELECT fm.homeTeam.name, fm.awayTeam.name, fm.homeTeam.teamResults, fm.awayTeam.teamResults FROM FootballMatch fm, TeamResult tr, Team t WHERE fm.footballMatchId = tr.footballMatch.footballMatchId AND fm.homeTeam.teamId = t.teamId AND fm.awayTeam.teamId = t.teamId")
	List<FootballMatch> findFootballMatchesResult();

	// new com.experisproject.experisproject.pojos.FootballMatchResultsInfo
}
