package com.experisproject.experisproject.models.repositories;


import com.experisproject.experisproject.models.entities.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalTypeRepository extends JpaRepository<GoalType, Integer> {

	@Query(value = "SELECT gt.type FROM GoalType gt")
	List<GoalType> findGoalTypes();
}
