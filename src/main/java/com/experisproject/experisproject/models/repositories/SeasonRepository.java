package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Season;
import com.experisproject.experisproject.projections.SeasonLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {

	@Query(value = "SELECT s.seasonId, s.name, s.startDate, s.endDate, s.description FROM Season s")
	List<Season> findSeasonsIdNameDatesDescription();

	@Query(value = "SELECT s FROM Season s")
	List<SeasonLimited> findAllLimited();
}
