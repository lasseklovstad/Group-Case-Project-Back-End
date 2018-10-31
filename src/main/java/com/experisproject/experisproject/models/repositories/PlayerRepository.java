package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.projections.PlayerLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findPlayerByTeam_NameContaining(String name);

	@Query(value = "SELECT p.playerId as playerId, CONCAT(p.person.firstName,' ',p.person.lastName) as fullName, p.team.teamId, p.team.name FROM Player p")
	List<Player> findPlayerShortInfo();

	@Query(value = "SELECT p.playerId ,CONCAT(p.person.firstName,' ',p.person.lastName),p.normalPosition FROM Player p WHERE p.team.teamId = :teamId")
	List<Player> findByTeamId(@Param("teamId") int teamId);

	@Query(value = "SELECT pl FROM Player pl INNER JOIN Person pers ON pl.person.personId = pers.personId INNER JOIN Team team ON pl.team.teamId = team.teamId")
	List<PlayerLimited> findAllLimited(); //works exactly the same
}
