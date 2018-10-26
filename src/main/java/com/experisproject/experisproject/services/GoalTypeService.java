package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.GoalType;
import com.experisproject.experisproject.models.repositories.GoalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalTypeService {


	private GoalTypeRepository goalTypeRepository;

	@Autowired
	public GoalTypeRepository goalTypeRepository(GoalTypeRepository goalTypeRepository) {
		return this.goalTypeRepository = goalTypeRepository;
	}

	public GoalType findById(int id) {
		return goalTypeRepository.findById(id).get();
	}

	public List<GoalType> findGoalTypes(){
		return goalTypeRepository.findGoalTypes();
	}


	public List<GoalType> findAll() {
		List<GoalType> result = new ArrayList<>();
		goalTypeRepository.findAll().forEach(goalType -> result.add(goalType));
		return result;
	}

	public void save(GoalType goalType) {
		goalTypeRepository.save(goalType);
	}

	public void deleteById(int id) {
		goalTypeRepository.deleteById(id);
	}

	public void deleteAll() {
		goalTypeRepository.deleteAll();
	}

}
