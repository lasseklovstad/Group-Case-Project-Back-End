package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.projections.CoachLimited;
import com.experisproject.experisproject.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coach")
@CrossOrigin
public class CoachController {

	@Autowired
	private CoachService coachService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<Coach>  getAllCoaches(){
		return coachService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<CoachLimited> getCoachesLimitedInfo(){
		return coachService.findAllLimited();
	}

	@RequestMapping(value = "/{id}")
	public Coach getCoachById(@PathVariable int id){
		Coach coach = coachService.findById(id);
		return coach;
	}



}
