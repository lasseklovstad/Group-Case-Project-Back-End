package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface TeamRepository extends JpaRepository<Team,Integer> {
    List<Team> findAllByNameContaining(String name);

    @Query(value = "select team.name from Team team")
    List<String> findAllNames();


}
