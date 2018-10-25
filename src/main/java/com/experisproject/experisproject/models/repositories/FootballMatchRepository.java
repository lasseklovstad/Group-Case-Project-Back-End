package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.pojos.FootballMatchResultsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootballMatchRepository extends JpaRepository<FootballMatch,Integer> {
/*
	@Query(value = "SELECT new com.experisproject.experisproject.pojos.FootballMatchResultsInfo(fm.homeTeam.name, fm.awayTeam.name, team.teamResult) FROM FootballMatch fm, TeamResult teamresult where fm.footballMatchId = teamresult.teamResultId")
	FootballMatchResultsInfo findFootballMatchesResult();
}*/

//@Query("SELECT new path_to_class.CustomMessage(m.author, m.text) FROM Message m WHERE m.id = :id")

}