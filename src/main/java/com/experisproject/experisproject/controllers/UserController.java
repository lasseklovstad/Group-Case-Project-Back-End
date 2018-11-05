package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.entities.Watchlist;
import com.experisproject.experisproject.models.forms.UserForm;
import com.experisproject.experisproject.services.UserService;
import com.experisproject.experisproject.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private WatchlistService watchlistService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getUsersIdUsernameEmail() {
		return userService.findUsersIdUsernameEmail();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	public List<User> getAllUsersInfo() {
		List<User> userList = userService.findAll();
		return userList;
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
	public User getByEmail(@PathVariable String email, HttpServletResponse response) {
		if(!userService.existsByEmail(email)){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}else{
			response.setStatus(HttpServletResponse.SC_OK);
		}


		return userService.findByEmail(email);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createUser(@RequestBody UserForm form, HttpServletResponse response) {
		if (form.getUserName().equals("admin") || form.getUserName().equals("tonje") || form.getUserName().equals("fredrik") || form.getUserName().equals("karoline")) {
			form.setAdmin(true);
		} else {
			form.setAdmin(false);
		}
		try {
			User user = new User(form.getUserName(), form.getEmail(), form.getPassword(), form.isAdmin());
			userService.save(user);
			Watchlist watchlist = new Watchlist(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), user);
			watchlistService.save(watchlist);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "fallback method";
	}

	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable int id){
		userService.deleteById(id);
	}




}
