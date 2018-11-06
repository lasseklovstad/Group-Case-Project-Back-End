package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.entities.Watchlist;
import com.experisproject.experisproject.models.forms.WatchlistForm;
import com.experisproject.experisproject.services.UserService;
import com.experisproject.experisproject.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('ADMIN')")
	public List<Watchlist> getWatchlistsIdsUserId() {
		return watchlistService.findWatchlists();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Watchlist> getAllInfo() {
		return watchlistService.findAll();
	}

	@RequestMapping(value = "/{id}/watchlist", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public Watchlist getWatchlistById(@PathVariable int id) {
		//if exists
		return watchlistService.findById(id);
	}

	@RequestMapping(value = "/{id}/byUserId", method = RequestMethod.GET)
	//able to get own watchlist
	@PreAuthorize("#id == authentication.principal.userId or hasRole('ADMIN')")
	public List<Watchlist> getWatchlistByUserId(@PathVariable int id) {
		//doesn't work as it is supposed to work... check if user created now when I changed constructor mistake made it work
		return watchlistService.findWatchListByUserId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
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

			if (!"0".equals(playerId)) {
				if (!playerIds.remove(playerId)){
					if (playerIds.size() < 5) {
						playerIds.add(playerId);
					} else { //if too many elements in list, send response - the ids are handling the logic
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					}
				}
			}
			if (!playerName.isEmpty()) { //logically this doesn't allow for players with same name to be added
				if (!playerNames.remove(playerName) && playerNames.size() < 5){
						playerNames.add(playerName);
				}
			}
			if (!"0".equals(teamId)) {
				if (!teamIds.remove(teamId)) {
					if (5 > teamIds.size()){
						teamIds.add(teamId);
					} else { //if too many elements in list, send response - the ids are handling the logic
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					}
				}
			}
			if (!teamName.isEmpty()) { //logically this doesn't allow for team with same name to be added (no prob - db doesn't allow it)
				if (!teamNames.remove(teamName) && teamNames.size() < 5) {
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
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
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
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteWatchlist(@PathVariable int id) {
		watchlistService.deleteById(id);
	}

}
