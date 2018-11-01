package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.TeamResult;
import com.experisproject.experisproject.models.repositories.TeamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamResultService {

	private TeamResultRepository teamResultRepository;

	@Autowired
	public TeamResultRepository teamResultRepository(TeamResultRepository teamResultRepository){
		return 	this.teamResultRepository = teamResultRepository;
	}

	public TeamResult findById(int id){
		return teamResultRepository.findById(id).get();
	}

	public List<TeamResult> findAll(){
		List<TeamResult> result = new ArrayList<>();
		teamResultRepository.findAll().forEach(teamResult -> result.add(teamResult));
		return result;
	}

	public void updatePlayer(TeamResult teamResult){
		save(teamResult);
	}

	public void save(TeamResult teamResult){
		teamResultRepository.save(teamResult);
	}


	public void deleteById(int id){
		teamResultRepository.findById(id);
	}



}
