package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.forms.UserForm;
import com.experisproject.experisproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAll() {
		List<User> userList = userService.findAll();
		return userList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	//@ResponseStatus(code = HttpStatus.OK)
	public void create(@RequestBody UserForm form, HttpServletResponse response) {
		if (form.getUserName().equals("admin")) {
			form.setAdmin(true);
		} else {
			form.setAdmin(false);
		}
		User user = new User(form.getUserName(), form.getEmail(), form.getPassword(), form.isAdmin());
	//	System.out.println(user.toString());
		userService.save(user);
		response.setStatus(HttpStatus.OK.value());
	}

	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "fallback method";
	}


}
