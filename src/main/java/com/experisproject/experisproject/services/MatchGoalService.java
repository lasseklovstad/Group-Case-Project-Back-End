package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.repositories.MatchGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchGoalService {

	private MatchGoalRepository matchGoalRepository;

	@Autowired
	public MatchGoalRepository matchGoalRepository(MatchGoalRepository matchGoalRepository){
		return this.matchGoalRepository = matchGoalRepository;
	}


}
