package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.MatchGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchGoalRepository extends JpaRepository<MatchGoal, Integer> {

	@Query(value = "SELECT mg.matchGoalId, mg.description, mg.goalType.goalTypeId, mg.goalType.type, mg.footballMatch.footballMatchId, mg.footballMatch.matchDate, mg.player.team.teamId, mg.player.team.name, mg.player.playerId, CONCAT(mg.player.person.firstName,' ', mg.player.person.lastName)  FROM MatchGoal mg")
	List<MatchGoal> findMatchGoalIdDescriptionGoalTypeMatchPlayer();
}
