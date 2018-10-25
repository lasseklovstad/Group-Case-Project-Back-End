package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.projections.PlayerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_NameContaining(String name);

	@Query(value = "SELECT p.playerId as playerId, p.person.firstName as firstName, p.person.lastName as lastName, p.team.name as team FROM Player p")
	List<Player> findPlayerShortInfo();

	@Query(value = "SELECT pl FROM Player pl, Person pers, Team team where pl.person.personId = pers.personId AND p.team.teamId = team.teamId")
	List<PlayerLimited> findAllLimited(); //works exactly the same

}
