package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.FavouriteList;
import com.experisproject.experisproject.models.entities.Users;
import com.experisproject.experisproject.models.forms.FavouriteListForm;
import com.experisproject.experisproject.models.security.services.UsersDetailsServiceImpl;
import com.experisproject.experisproject.services.FavouriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/favouriteList")
@CrossOrigin
public class FavouriteListController {

	@Autowired
	private FavouriteListService favouriteListService;
	@Autowired
	private UsersDetailsServiceImpl usersService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<FavouriteList> getWatchlistsIdsUserId() {
		return favouriteListService.findFavouriteLists();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<FavouriteList> getAllInfo() {
		return favouriteListService.findAll();
	}

	@RequestMapping(value = "/{id}/byId", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public FavouriteList getFavouriteListById(@PathVariable int id) {
		//if exists
		return favouriteListService.findById(id);
	}

	@RequestMapping(value = "/{id}/byUserId", method = RequestMethod.GET)
	//able to get own favouriteList
	@PreAuthorize("#id == authentication.principal.userId or hasRole('ADMIN')")
	public List<FavouriteList> getFavouriteListByUserId(@PathVariable int id) {
		//doesn't work as it is supposed to work... check if user created now when I changed constructor mistake made it work
		return favouriteListService.findFavouriteListByUserId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void createFavouriteList(@RequestBody FavouriteListForm form, HttpServletResponse response) {
		//if exists
		try {
			Users user = usersService.findById(form.getUserId());
			ArrayList<String> playerIds = new ArrayList<>();
			ArrayList<String> playerNames = new ArrayList<>();
			ArrayList<String> teamIds = new ArrayList<>();
			ArrayList<String> teamNames = new ArrayList<>();

			FavouriteList favouriteList = new FavouriteList(playerIds, playerNames, teamIds, teamNames, user);
			favouriteListService.save(favouriteList);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.getCause();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public void updateFavouriteList(@RequestBody FavouriteListForm form, HttpServletResponse response) {
		//if exists
		try {
			FavouriteList favouriteList  = favouriteListService.findFavouriteListByUserIdGenerated(form.getUserId());
			ArrayList<String> playerIds = favouriteList.getPlayerIds();
			ArrayList<String> playerNames = favouriteList.getPlayerNames();
			ArrayList<String> teamIds = favouriteList.getTeamIds();
			ArrayList<String> teamNames = favouriteList.getTeamNames();

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
					if ( 5 > teamIds.size()){
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
			favouriteList.setPlayerIds(playerIds);
			favouriteList.setPlayerNames(playerNames);
			favouriteList.setTeamIds(teamIds);
			favouriteList.setTeamNames(teamNames);
			favouriteListService.updateFavouriteList(favouriteList);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(value = "/{userId}/clear", method = RequestMethod.GET)
	@PreAuthorize("#userId == authentication.principal.userId or hasRole('ADMIN')")
	public void clearFavouriteList(@PathVariable int userId) {
		//set all the lists to new lists, we still want the list to exist
		FavouriteList favouriteList = favouriteListService.findFavouriteListByUserIdGenerated(userId);
		favouriteList.setPlayerIds(new ArrayList<>());
		favouriteList.setPlayerNames(new ArrayList<>());
		favouriteList.setTeamIds(new ArrayList<>());
		favouriteList.setTeamNames(new ArrayList<>());
		favouriteListService.updateFavouriteList(favouriteList);
	}



}
