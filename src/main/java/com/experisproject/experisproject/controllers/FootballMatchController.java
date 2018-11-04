package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.forms.FootballMatchForm;
import com.experisproject.experisproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
	@Autowired
	private TeamResultService teamResultService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatchesInfo() {
		return footballMatchService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatches() {
		return footballMatchService.findFootballMatchIdDateSeasonLocationTeamsPlayers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FootballMatch getFootballMatchById(@PathVariable int id) {
		return footballMatchService.findById(id);
	}

	//need to check something
	@RequestMapping(value = "/all/result", method = RequestMethod.GET)
	public List<FootballMatch> getFootballMatchesResult() {
		return footballMatchService.findFootballMatchesResult();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createFootballMatch(@RequestBody FootballMatchForm form, HttpServletResponse response) {
		try {
			Season season = seasonService.findById(form.getSeasonId());
			Location location = locationService.findById(form.getLocationId());
			Team homeTeam = teamService.findById(form.getHomeTeamId());
			Team awayTeam = teamService.findById(form.getAwayTeamId());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dtf = dtf.withLocale(Locale.US);
			LocalDate matchDate = LocalDate.parse(form.getDate(),dtf);
			Set<Player> players = new HashSet<>();
			if (form.getPlayerIds() != null) {
				players = convertIdsToPlayers(form.getPlayerIds());
			}
			FootballMatch footballMatch = new FootballMatch(matchDate, season, location, homeTeam, awayTeam, players);
			footballMatchService.save(footballMatch);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateFootballMatch(@RequestBody FootballMatchForm form, HttpServletResponse response) {
		try {
			FootballMatch footballMatch = footballMatchService.findById(form.getFootballMatchId());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dtf = dtf.withLocale(Locale.US);
			LocalDate matchDate = LocalDate.parse(form.getDate(),dtf);
			footballMatch.setMatchDate(matchDate);
			footballMatch.setSeason(seasonService.findById(form.getSeasonId()));
			footballMatch.setLocation(locationService.findById(form.getLocationId()));
			footballMatch.setHomeTeam(teamService.findById(form.getHomeTeamId()));
			footballMatch.setAwayTeam(teamService.findById(form.getAwayTeamId()));
			//it's possible to change players for the game to zero
			Set<Player> players = convertIdsToPlayers(form.getPlayerIds());
			footballMatch.setPlayers(players);

			footballMatchService.updateFootballMatch(footballMatch);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	private Set<Player> convertIdsToPlayers(ArrayList<String> playerIds) {
		Set<Player> players = new HashSet<>();
		for (String playerId : playerIds) {
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
