package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.projections.PlayerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_NameContaining(String name);

	@Query(value = "SELECT p.playerId as playerId, CONCAT(p.person.firstName,' ',p.person.lastName) as fullName, p.team.name as team FROM Player p")
	List<Player> findPlayerShortInfo();

	@Query(value = "SELECT pl FROM Player pl INNER JOIN Person pers ON pl.person.personId = pers.personId INNER JOIN Team team ON pl.team.teamId = team.teamId")
	List<PlayerLimited> findAllLimited(); //works exactly the same
}
