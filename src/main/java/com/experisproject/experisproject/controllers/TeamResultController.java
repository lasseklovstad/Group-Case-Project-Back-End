package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.TeamResult;
import com.experisproject.experisproject.services.TeamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/teamResult")
@CrossOrigin
public class TeamResultController {

	@Autowired
	private TeamResultService teamResultService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<TeamResult> getTeamResultsInfo(){
		return teamResultService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TeamResult> getTeamResultsIdGoalsResultTeamIdName(){
		return teamResultService.findTeamResultsIdGoalsResultTeamIdName();
	}







}
