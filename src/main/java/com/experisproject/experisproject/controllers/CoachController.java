package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coach")
@CrossOrigin
public class CoachController {

	@Autowired
	private CoachService coachService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Coach>  findAllCoaches(){
		return coachService.findAll();
	}




}
