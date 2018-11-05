package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.entities.TeamResult;
import com.experisproject.experisproject.models.forms.TeamResultForm;
import com.experisproject.experisproject.services.FootballMatchService;
import com.experisproject.experisproject.services.TeamResultService;
import com.experisproject.experisproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/teamResult")
@CrossOrigin
public class TeamResultController {

	@Autowired
	private TeamResultService teamResultService;
	@Autowired
	private FootballMatchService footballMatchService;
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<TeamResult> getTeamResultsInfo() {
		return teamResultService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TeamResult> getTeamResultsIdGoalsResultTeamIdName() {
		return teamResultService.findTeamResultsIdGoalsResultTeamIdName();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TeamResult getTeamResultById(@PathVariable int id) {
		return teamResultService.findById(id);
	}

	@GetMapping(value = "/homeTeam")
	public List<TeamResult> findHomeTeamResults(){
		return teamResultService.findHomeTeamResults();
	}

	@GetMapping(value = "/awayTeam")
	public List<TeamResult> findAwayTeamResults() {
		return teamResultService.findAwayTeamResults();
	}


	@RequestMapping(value = "/{id}/byFootballMatchId", method = RequestMethod.GET)
	public 	List<TeamResult> getTeamResultsByFootballMatchId(@PathVariable int id){
		return teamResultService.findTeamResultsByFootballMatchId(id);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createTeamResult(@RequestBody TeamResultForm form, HttpServletResponse response) {
		try {
			FootballMatch footballMatch = footballMatchService.findById(form.getFootballMatchId());
			Team team = teamService.findById(form.getTeamId());

			TeamResult teamResult = new TeamResult(form.getGoals(), form.getResult(), footballMatch, team);
			teamResultService.save(teamResult);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateTeamResult(@RequestBody TeamResultForm form, HttpServletResponse response) {
		//if exists?
		try {
			TeamResult teamResult = teamResultService.findById(form.getTeamResultId());
			teamResult.setGoals(form.getGoals());
			teamResult.setResult(form.getResult());
			teamResult.setFootballMatch(footballMatchService.findById(form.getFootballMatchId()));
			teamResult.setTeam(teamService.findById(form.getTeamId()));
			teamResultService.updatePlayer(teamResult);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteTeamResultById(@PathVariable int id) {
		teamResultService.deleteById(id);
	}


}
