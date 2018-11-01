package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.TeamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamResultRepository extends JpaRepository<TeamResult, Integer> {



}
