package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.forms.UserForm;
import com.experisproject.experisproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAll() {
		List<User> userList = userService.findAll();
		return userList;
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseStatus(code = HttpStatus.OK)
	public void create(@RequestBody UserForm form) {
		if (form.getUserName().equals("admin")) {
			form.setAdmin(true);
		} else {
			form.setAdmin(false);
		}
		User user = new User(form.getUserName(), form.getEmail(), form.getPassword(), form.isAdmin());

		userService.save(user);
	}


	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "fallback method";
	}


}
