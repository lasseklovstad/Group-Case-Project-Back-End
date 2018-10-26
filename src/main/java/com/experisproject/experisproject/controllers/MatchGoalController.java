package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.GoalType;
import com.experisproject.experisproject.services.GoalTypeService;
import com.experisproject.experisproject.services.MatchGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/matchGoal")
@CrossOrigin
public class MatchGoalController {
	@Autowired
	MatchGoalService matchGoalService;

	@Autowired
	GoalTypeService goalTypeService;


	@RequestMapping(value = "/goalType/all", method = RequestMethod.GET)
	public List<GoalType> getGoalTypes(){
		return goalTypeService.findAll();
	}

	@RequestMapping(value = "/goalType/{id}", method = RequestMethod.GET)
	public GoalType getById(@PathVariable int id) {
		return goalTypeService.findById(id);
	}


	@RequestMapping(value = "/goalType", method = RequestMethod.POST)
	public void create(@RequestBody GoalType goalType, HttpServletResponse response){
		goalTypeService.save(goalType);
		response.setStatus(HttpStatus.CREATED.value());
	}

	//@RequestMapping(value = "/goalType", method = RequestMethod.PUT)


	@RequestMapping(value = "/goalType/{id}", method = RequestMethod.DELETE)
	public void deleteGoalTypeById(@PathVariable int id, HttpServletResponse response) {
		 goalTypeService.deleteById(id);
		 response.setStatus(HttpStatus.OK.value());
	}


}
