package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.repositories.TeamRepository;
import com.experisproject.experisproject.projections.TeamLimited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
	private TeamRepository teamRepository;

	@Autowired
	public TeamRepository teamRepository(TeamRepository teamRepository) {
		return this.teamRepository = teamRepository;
	}


	public Team findById(int id) {
		return teamRepository.findById(id).get();
	}

	public List<Team> findAllByName(String name) {
		return teamRepository.findAllByNameContaining(name);
	}

	public List<Team> findTeamsIdsNameCoachLocation(){
		return teamRepository.findTeamsIdsNameCoachLocation();
	}

	public List<TeamLimited> findAllLimited() {
		return teamRepository.findAllRemodelTeams();
	}

	public List<Team> findAll() {
		List<Team> result = new ArrayList<>();
		teamRepository.findAll().forEach(team -> result.add(team));
		return result;
	}

	public void updateTeam(Team team){
		save(team);
	}
	public void save(Team team) {
		teamRepository.save(team);
	}

	public void deleteById(int id){
		teamRepository.deleteById(id);
	}

	public void deleteAll() {
		teamRepository.deleteAll();
	}

}
