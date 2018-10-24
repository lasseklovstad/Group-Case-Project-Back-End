package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.projections.PlayerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_NameContaining(String name);

	@Query(value = "SELECT p.playerId, p.person.firstName, p.person.lastName, p.team.name FROM Player p")
	List<Player> findPlayerShortInfo();

	@Query(value = "SELECT p.playerId as playerId, p.person as person, p.team as team FROM Player p")
	List<PlayerLimited> findAllLimited();

}
