package com.experisproject.experisproject.models.repositories;


import com.experisproject.experisproject.models.entities.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTypeRepository extends JpaRepository<GoalType, Integer> {
}
