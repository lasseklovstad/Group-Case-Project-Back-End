package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.forms.MatchGoalForm;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@Autowired
	private TeamResultService teamResultService;

	private MatchGoalForm form;


	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<MatchGoal> getAllMatchGoals() {
		return matchGoalService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<MatchGoal> getMatchGoals() {
		return matchGoalService.findMatchGoalIdDescriptionGoalTypeMatchPlayer();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public MatchGoal getMatchGoalById(@PathVariable int id, HttpServletResponse response) {
		return matchGoalService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createMatchGoal(@RequestBody MatchGoalForm form, HttpServletResponse response) {
		try {
			this.form = form;
			GoalType goalType = goalTypeService.findById(form.getGoalTypeId());
			FootballMatch footballMatch = footballMatchService.findById(form.getFootballMatchId());
			Player player = playerService.findById(form.getPlayerId());
			MatchGoal matchGoal = new MatchGoal(form.getDescription(), goalType, footballMatch, player);
			matchGoalService.save(matchGoal);
			System.out.println("saved matchgoal");
			int goal = 1;
			updateTeamResults(form, goal);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	private void updateTeamResults(MatchGoalForm form, int goal) {
		if (teamResultService.existsByFootballMatchIdAndAndTeamId(form.getFootballMatchId(), form.getTeamId())) {
			List<TeamResult> results = teamResultService.findRealTeamResultsByFootballMatchId(form.getFootballMatchId());

			TeamResult teamResult = teamResultService.findByFootballMatchIdAndTeamId(form.getFootballMatchId(), form.getTeamId());
			teamResult.setGoals(teamResult.getGoals() + goal);

			int teamIndex = 0;
			int otherIndex = 1;
			if (form.getTeamId() == results.get(0).getTeam().getTeamId()) {
				teamIndex = 0;
				otherIndex = 1;
			} else {
				teamIndex = 1;
				otherIndex = 0;
			}
			TeamResult thisTeamResult = results.get(teamIndex);
			TeamResult otherTeamResult = results.get(otherIndex);

			if (thisTeamResult.getResult().matches(("draw")) || thisTeamResult.getResult().matches("win")) {
				thisTeamResult.setResult("win");
				otherTeamResult.setResult("loss");
			}

			int diff = thisTeamResult.getGoals() - otherTeamResult.getGoals();
			if (diff < -1) {
				thisTeamResult.setResult("win");
				otherTeamResult.setResult("loss");
			} else if (diff == 0) {
				thisTeamResult.setResult("draw");
				otherTeamResult.setResult("draw");
			}
			teamResultService.updateTeamResult(thisTeamResult);
			teamResultService.updateTeamResult(otherTeamResult);
		}
	}


	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updateMatchGoal(@RequestBody MatchGoalForm form, HttpServletResponse response) {
		try {
			MatchGoal matchGoal = matchGoalService.findById(form.getMatchGoalId());
			matchGoal.setDescription(form.getDescription());
			matchGoal.setGoalType(goalTypeService.findById(form.getGoalTypeId()));
			matchGoal.setFootballMatch(footballMatchService.findById(form.getFootballMatchId()));
			matchGoal.setPlayer(playerService.findById(form.getPlayerId()));

			//change the things into teamResult, find logid to do so.. if changes the player, and goalType
			matchGoalService.updateMatchGoal(matchGoal); //save()
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteMatchGoalById(@PathVariable int id, HttpServletResponse response) {
		try {
			matchGoalService.deleteById(id);
			//int goal = -1;
			//updateTeamResults(form,goal);
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
	@PreAuthorize("hasRole('ADMIN')")
	public List<GoalType> getGoalTypes() {
		return goalTypeService.findAll();
	}

	@RequestMapping(value = "/goalType/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public GoalType getById(@PathVariable int id) {
		return goalTypeService.findById(id);
	}


	@RequestMapping(value = "goalType/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<GoalType> findGoalTypes() {
		return goalTypeService.findGoalTypes();
	}

	@RequestMapping(value = "/goalType", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
	public void updateGoalType(@RequestBody GoalType goalType, HttpServletResponse response) {
		try {
			goalTypeService.updateGoalType(goalType);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}


	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/goalType/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteGoalTypeById(@PathVariable int id, HttpServletResponse response) {
		goalTypeService.deleteById(id);
		response.setStatus(HttpStatus.OK.value());
	}


}
