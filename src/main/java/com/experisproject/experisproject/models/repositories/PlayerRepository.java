package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_NameContaining(String teamName);

	@Query(value = "select pl.playerId, pl.person.firstName, pl.person.lastName, pl.team.name from Player pl")
	List<Player> getPlayerIdNameAndTeam();


}
