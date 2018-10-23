package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.projections.TeamLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeamRepository extends JpaRepository<Team,Integer> {
    List<Team> findAllByNameContaining(String name);

    @Query(value = "SELECT team FROM Team team")
    List<TeamLimited> findAllRemodelTeams();
}
