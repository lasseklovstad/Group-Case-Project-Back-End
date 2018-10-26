package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.MatchGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchGoalRepository extends JpaRepository<MatchGoal, Integer> {


}
