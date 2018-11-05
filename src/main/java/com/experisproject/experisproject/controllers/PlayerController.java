package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Person;
import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.forms.PlayerForm;
import com.experisproject.experisproject.projections.PlayerLimited;
import com.experisproject.experisproject.services.AddressService;
import com.experisproject.experisproject.services.PersonService;
import com.experisproject.experisproject.services.PlayerService;
import com.experisproject.experisproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/api/player")
@CrossOrigin
public class PlayerController {

	@Autowired
	private PersonService personService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Player> getAll(HttpServletRequest req, HttpServletResponse res) {
		return playerService.findAll();
	}

	@RequestMapping(value = "/byTeamName/{teamName}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Player> getPlayersByTeamName(@PathVariable String teamName) {
		return playerService.findPlayerByTeamName(teamName);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Player> getAllPlayersIdNameAndTeam() {
		return playerService.findPlayerShortInfo();
	}

	@RequestMapping(value = "limitedInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<PlayerLimited> getPlayersLimitedInfo() {
		return playerService.findAllLimited();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Player getById(@PathVariable int id) {
		return playerService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createPlayer( @RequestBody PlayerForm form, HttpServletResponse response ) {
		try {
			//Create new player
			Person person = personService.findById(form.getPersonId());
			Team team = teamService.findById(form.getTeamId());
			Player player = new Player(form.getNumber(), form.getNormalPosition(), person, team, null);

			playerService.save(player);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updatePlayer(@RequestBody PlayerForm form, HttpServletResponse response ) {
		try {
			//Update player
			Player player = playerService.findById(form.getPersonId());
			player.setNumber(form.getNumber());
			player.setNormalPosition(form.getNormalPosition());
			player.setPerson(personService.findById(form.getPersonId()));
			player.setTeam(teamService.findById(form.getTeamId()));

			playerService.updatePlayer(player);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deletePlayerById(@PathVariable int id, HttpServletResponse response) {
		try {
			playerService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			ex.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}