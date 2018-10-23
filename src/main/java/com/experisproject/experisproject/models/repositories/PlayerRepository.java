package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_Name(String teamName);

	@Query("select person.firstName, person.lastName from Player pl, Person person where pl.personId = person.personId")
	List<Object> getPlayerName();


}
