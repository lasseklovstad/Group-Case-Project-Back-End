package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.forms.FootballMatchForm;
import com.experisproject.experisproject.pojos.FootballMatchResultsInfo;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/footballMatch")
@CrossOrigin
public class FootballMatchController {

	@Autowired
	private FootballMatchService footballMatchService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatchesInfo() {
		return footballMatchService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FootballMatch getFootballMatchById(@PathVariable int id) {
		return footballMatchService.findById(id);
	}

	@RequestMapping(value = "/all/result", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatchesResult() {
		return footballMatchService.findFootballMatchesResult();
	}

	//  @RequestMapping(value = "" , method = RequestMethod.POST)
	//    public void create(
	//            @RequestBody FootballMatchForm form,
	//            HttpServletResponse response
	//    ){//create new match -> save()}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createFootballMatch(@RequestBody FootballMatchForm form, HttpServletResponse response) {
		try {
			Season season = seasonService.findById(form.getSeasonId());
			Location location = locationService.findById(form.getLocationId());
			Team homeTeam = teamService.findById(form.getHomeTeamId());
			Team awayTeam = teamService.findById(form.getAwayTeamId());
			LocalDate matchDate = LocalDate.of(form.getYear(), form.getMonth(), form.getDay());
			Set<Player> players = convertIdsToPlayers(form.getPlayerIds());

			FootballMatch footballMatch = new FootballMatch(matchDate,season,location, homeTeam, awayTeam, players);
			footballMatchService.save(footballMatch);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateFootballMatch(@RequestBody FootballMatchForm form, HttpServletResponse response) {
		try {
			FootballMatch footballMatch = footballMatchService.findById(form.getFootballMatchId());
			LocalDate matchDate = LocalDate.of(form.getYear(), form.getMonth(), form.getDay());
			footballMatch.setMatchDate(matchDate);
			footballMatch.setSeason(seasonService.findById(form.getSeasonId()));
			footballMatch.setLocation(locationService.findById(form.getLocationId()));
			footballMatch.setHomeTeam(teamService.findById(form.getHomeTeamId()));
			footballMatch.setAwayTeam(teamService.findById(form.getAwayTeamId()));
			Set<Player> players = convertIdsToPlayers(form.getPlayerIds());
			footballMatch.setPlayers(players);
			footballMatchService.updateFootballMatch(footballMatch);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	private Set<Player> convertIdsToPlayers(ArrayList<String> playerIds){
		Set<Player> players = new HashSet<>();
		for(String playerId : playerIds) {
			players.add(playerService.findById(Integer.parseInt(playerId)));
		}
		return players;
	}


	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteFootballMatchById(@PathVariable int id, HttpServletResponse response) {
		try {
			footballMatchService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
