package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.pojos.FootballMatchResultsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootballMatchRepository extends JpaRepository<FootballMatch,Integer> {

	@Query(value = "SELECT fm.homeTeam.name, fm.awayTeam.name, fm.homeTeam.teamResults, fm.awayTeam.teamResults FROM FootballMatch fm, TeamResult tr, Team t WHERE fm.footballMatchId = tr.footballMatch.footballMatchId AND fm.homeTeam.teamId = t.teamId AND fm.awayTeam.teamId = t.teamId")
	List<FootballMatch> findFootballMatchesResult();

// new com.experisproject.experisproject.pojos.FootballMatchResultsInfo
}