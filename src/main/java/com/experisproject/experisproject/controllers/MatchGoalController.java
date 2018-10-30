package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.entities.GoalType;
import com.experisproject.experisproject.models.entities.MatchGoal;
import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.forms.MatchGoalForm;
import com.experisproject.experisproject.services.FootballMatchService;
import com.experisproject.experisproject.services.GoalTypeService;
import com.experisproject.experisproject.services.MatchGoalService;
import com.experisproject.experisproject.services.PlayerService;
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
	private MatchGoalService matchGoalService;
	@Autowired
	private GoalTypeService goalTypeService;
	@Autowired
	private FootballMatchService footballMatchService;
	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<MatchGoal> getAllMatchGoals() {
		return matchGoalService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<MatchGoal> getMatchGoals() {
		return matchGoalService.findMatchGoalIdDescriptionGoalTypeMatchPlayer();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MatchGoal getMatchGoalById(@PathVariable int id, HttpServletResponse response) {
		return matchGoalService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createMatchGoal(@RequestBody MatchGoalForm form, HttpServletResponse response) {
		try {
			GoalType goalType = goalTypeService.findById(form.getGoalTypeId());
			FootballMatch footballMatch = footballMatchService.findById(form.getFootballMatchId());
			Player player = playerService.findById(form.getPlayerId());
			MatchGoal matchGoal = new MatchGoal(form.getDescription(), goalType, footballMatch, player);
			matchGoalService.save(matchGoal);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateMatchGoal(@RequestBody MatchGoalForm form, HttpServletResponse response) {
		try {
			MatchGoal matchGoal = matchGoalService.findById(form.getMatchGoalId());
			matchGoal.setDescription(form.getDescription());
			matchGoal.setGoalType(goalTypeService.findById(form.getGoalTypeId()));
			matchGoal.setFootballMatch(footballMatchService.findById(form.getFootballMatchId()));
			matchGoal.setPlayer(playerService.findById(form.getPlayerId()));
			matchGoalService.updateMatchGoal(matchGoal); //save()
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	public void deleteMatchGoalById(@PathVariable int id, HttpServletResponse response) {
		try {
			matchGoalService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}


	/* *********************************************************************************
	 *                  GOALTYPE MAPPING AND REQUEST METHODS							 *
	 ***********************************************************************************/
	@RequestMapping(value = "/goalType/allInfo", method = RequestMethod.GET)
	public List<GoalType> getGoalTypes() {
		return goalTypeService.findAll();
	}

	@RequestMapping(value = "/goalType/{id}", method = RequestMethod.GET)
	public GoalType getById(@PathVariable int id) {
		return goalTypeService.findById(id);
	}

	@RequestMapping(value = "goalType/all", method = RequestMethod.GET)
	public List<GoalType> findGoalTypes() {
		return goalTypeService.findGoalTypes();
	}

	@RequestMapping(value = "/goalType", method = RequestMethod.POST)
	public void createGoalType(@RequestBody GoalType goalType, HttpServletResponse response) {
		try {
			goalTypeService.save(goalType);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/goalType", method = RequestMethod.PUT)
	public void updateGoalType(@RequestBody GoalType goalType, HttpServletResponse response) {
		try {
			goalTypeService.updateGoalType(goalType);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/goalType/{id}/delete", method = RequestMethod.DELETE)
	public void deleteGoalTypeById(@PathVariable int id, HttpServletResponse response) {
		goalTypeService.deleteById(id);
		response.setStatus(HttpStatus.OK.value());
	}


}
