package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Users;
import com.experisproject.experisproject.models.forms.UserForm;
import com.experisproject.experisproject.models.security.services.UsersDetailsServiceImpl;
import com.experisproject.experisproject.services.FavouriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin
public class UsersController {

	@Autowired
	private UsersDetailsServiceImpl usersService;
	@Autowired
	private FavouriteListService favouriteListService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Users> getUsersIdUsernameEmail() {
		return usersService.findUsersIdUsernameEmail();
	}

	@RequestMapping(value = "/allInfo", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Users> getAllUsersInfo() {
		List<Users> userList = usersService.findAll();
		return userList;
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	@PreAuthorize("#id == authentication.principal.userId or hasRole('ADMIN')")
	public Users getUserById(@PathVariable int id) {
		return usersService.findById(id);
	}

	@RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
	@PreAuthorize("#email == authentication.principal.email or hasRole('ADMIN')")
	public Users getByEmail(@PathVariable String email, HttpServletResponse response) {
		if(usersService.existsByEmail(email)){
			response.setStatus(HttpServletResponse.SC_OK);
		}else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		return usersService.findByEmail(email);
	}
/*
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createUser(@RequestBody UserForm form, HttpServletResponse response) {
		if (form.getUserName().equals("admin") || form.getUserName().equals("tonje") || form.getUserName().equals("fredrik") || form.getUserName().equals("karoline")) {
			form.setAdmin(true);
		} else {
			form.setAdmin(false);
		}
		try {
			Users users = new Users(form.getUserName(), form.getEmail(), form.getPassword());
			usersService.save(users);
			Watchlist watchlist = new Watchlist(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), user);
			watchlistService.save(watchlist);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}*/

	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "fallback method";
	}

	/*--------------------------------------------------------------------------------------*
	 *                                DELETE MAPPING/METHODS                                *
	 * -------------------------------------------------------------------------------------*/

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUserById(@PathVariable int id){
		usersService.deleteById(id);
	}




}

