package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.MatchGoal;
import com.experisproject.experisproject.models.repositories.MatchGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchGoalService {

	private MatchGoalRepository matchGoalRepository;

	@Autowired
	public MatchGoalRepository matchGoalRepository(MatchGoalRepository matchGoalRepository){
		return this.matchGoalRepository = matchGoalRepository;
	}

	public List<MatchGoal> findMatchGoalIdDescriptionGoalTypeMatchPlayer(){
		return matchGoalRepository.	findMatchGoalIdDescriptionGoalTypeMatchPlayer();
	}


	public MatchGoal findById(int id){
		return matchGoalRepository.findById(id).get();
	}

	public List<MatchGoal> findAll(){
		List<MatchGoal> result = new ArrayList<>();
		matchGoalRepository.findAll().forEach(player->result.add(player));
		return result;
	}

	public void deleteById(int id){
		matchGoalRepository.deleteById(id);
	}


}
