package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.entities.Watchlist;
import com.experisproject.experisproject.models.forms.WatchlistForm;
import com.experisproject.experisproject.services.UserService;
import com.experisproject.experisproject.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/watchlist")
@CrossOrigin
public class WatchlistController {

	@Autowired
	private WatchlistService watchlistService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Watchlist> getWatchlistsIdsUserId() {
		return watchlistService.findWatchlists();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<Watchlist> getAllInfo() {
		return watchlistService.findAll();
	}

	@RequestMapping(value = "/{id}/watchlist", method = RequestMethod.GET)
	public Watchlist getWatchlistById(@PathVariable int id) {
		//if exists
		return watchlistService.findById(id);
	}

	@RequestMapping(value = "/{id}/byUserId", method = RequestMethod.GET)
	public List<Watchlist> getWatchlistByUserId(@PathVariable int id) {
		//doesn't work as it is supposed to work... check if user created now when I changed constructor mistake made it work
		return watchlistService.findWatchListByUserId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createWatchlist(@RequestBody WatchlistForm form, HttpServletResponse response) {
		//if exists
		try {
			User user = userService.findById(form.getUserId());
			ArrayList<String> playerIds = new ArrayList<>();
			ArrayList<String> playerNames = new ArrayList<>();
			ArrayList<String> teamIds = new ArrayList<>();
			ArrayList<String> teamNames = new ArrayList<>();

			Watchlist watchlist = new Watchlist(playerIds, playerNames, teamIds, teamNames, user);
			watchlistService.save(watchlist);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateWatchlist(@RequestBody WatchlistForm form, HttpServletResponse response) {
		//if exists
		try {
			Watchlist watchlist = watchlistService.findWatchlistByUserIdGenerated(form.getUserId());
			ArrayList<String> playerIds = watchlist.getPlayerIds();
			ArrayList<String> playerNames = watchlist.getPlayerNames();
			ArrayList<String> teamIds = watchlist.getTeamIds();
			ArrayList<String> teamNames = watchlist.getTeamNames();

			String playerId = Integer.toString(form.getPlayerId());
			String playerName = form.getPlayerName();
			String teamId = Integer.toString(form.getTeamId());
			String teamName = form.getTeamName();

			if (!"0".equals(playerId) && playerIds.size()<6) {
				if (!playerIds.remove(playerId)) {
					playerIds.add(playerId);
				}
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			if (!playerName.isEmpty() && playerNames.size()<6) {
				if (!playerNames.remove(playerName)) {
					playerNames.add(playerName);
				}
			}
			if (!"0".equals(teamId) && teamIds.size()<6) {
				if (!teamIds.remove(teamId)) {
					teamIds.add(teamId);
				}
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			if (!teamName.isEmpty() && teamNames.size()<6) {
				if (!teamNames.remove(teamName)) {
					teamNames.add(teamName);
				}
			}
			watchlist.setPlayerIds(playerIds);
			watchlist.setPlayerNames(playerNames);
			watchlist.setTeamIds(teamIds);
			watchlist.setTeamNames(teamNames);
			watchlistService.updateWatchlist(watchlist);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}/clear", method = RequestMethod.GET)
	public void clearWatchlist(@PathVariable int id) {
		//set all the lists to new lists, we still want the list to exist
		Watchlist watchlist = watchlistService.findWatchlistByUserIdGenerated(id);
		watchlist.setPlayerIds(new ArrayList<>());
		watchlist.setPlayerNames(new ArrayList<>());
		watchlist.setTeamIds(new ArrayList<>());
		watchlist.setTeamNames(new ArrayList<>());
		watchlistService.updateWatchlist(watchlist);
	}

	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteWatchlist(@PathVariable int id) {
		watchlistService.deleteById(id);
	}

}
