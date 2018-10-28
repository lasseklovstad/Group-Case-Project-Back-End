package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.MatchGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchGoalRepository extends JpaRepository<MatchGoal, Integer> {

	@Query(value = "SELECT mg.matchGoalId, mg.description, mg.goalType, mg.footballMatch.footballMatchId, mg.footballMatch.homeTeam, mg.footballMatch.awayTeam, mg.player.playerId, CONCAT(mg.player.person.firstName,' ', mg.player.person.firstName)  FROM MatchGoal mg")
	List<MatchGoal> findMatchGoalIdDescriptionGoalTypeMatchPlayer();
}
