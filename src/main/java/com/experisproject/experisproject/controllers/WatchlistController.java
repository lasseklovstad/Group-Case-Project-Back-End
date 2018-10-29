package com.experisproject.experisproject.controllers;


import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.entities.Watchlist;
import com.experisproject.experisproject.models.forms.WatchlistForm;
import com.experisproject.experisproject.services.UserService;
import com.experisproject.experisproject.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Watchlist getWatchlistById(@PathVariable int id) {
		//if exists
		return watchlistService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createWatchlist(@RequestBody WatchlistForm form, HttpServletResponse response) {
		//if exists
		try {
			User user = userService.findById(form.getUserId());
			Watchlist watchlist = new Watchlist(form.getPlayerIds(), form.getTeamIds(), user);
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
			Watchlist watchlist = watchlistService.findById(form.getWatchlistId());
			watchlist.setPlayerIds(form.getPlayerIds());
			watchlist.setTeamIds(form.getTeamIds());
			watchlistService.updateWatchlist(watchlist);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteWatchlist(@PathVariable int id) {
		//check if exists
		watchlistService.deleteById(id);
	}

}
