package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Season;
import com.experisproject.experisproject.projections.SeasonLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,Integer> {

    @Query(value = "SELECT s FROM Season s")
    List<SeasonLimited> findAllLimited();
}
