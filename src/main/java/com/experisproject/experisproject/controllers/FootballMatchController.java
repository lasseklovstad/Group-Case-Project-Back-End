package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.pojos.FootballMatchResultsInfo;
import com.experisproject.experisproject.services.FootballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/footballMatch")
@CrossOrigin
public class FootballMatchController {

	@Autowired
	private FootballMatchService footballMatchService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatchesInfo() {
		return footballMatchService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FootballMatch getFootballMatchById(@PathVariable int id) {
		return footballMatchService.findById(id);
	}

	@RequestMapping(value = "/all/result")
	public List<FootballMatch> getFootballMatchesResult() {
		return footballMatchService.findFootballMatchesResult();
	}

	//  @RequestMapping(value = "" , method = RequestMethod.POST)
	//    public void create(
	//            @RequestBody FootballMatchForm form,
	//            HttpServletResponse response
	//    ){//create new match -> save()}


}
