package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.projections.CoachLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

	@Query(value = "SELECT  c.coachId, CONCAT(c.person.firstName,' ',c.person.lastName),c.team.teamId ,c.team.name FROM Coach c")
	List<Coach> findCoachesIdNameAndTeam();

	//List<Coach> findTeam_NameByCoachId();

	@Query(value = "SELECT c FROM Coach c")
	List<CoachLimited> findAllLimited();
}
