package com.experisproject.experisproject.controllers;


/*AuthRestAPIs.java defines 2 APIs:

/api/auth/signup: sign up
-> check username/email is already in use.
-> create User object
-> store to database
/api/auth/signin: sign in
-> attempt to authenticate with AuthenticationManager bean.
-> add authentication object to SecurityContextHolder
-> Generate JWT token, then return JWT to client
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.experisproject.experisproject.message.request.LoginForm;
import com.experisproject.experisproject.message.request.SignUpForm;
import com.experisproject.experisproject.message.response.JwtResponse;
import com.experisproject.experisproject.message.response.Response;
import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.repositories.RoleRepository;
import com.experisproject.experisproject.models.repositories.UsersRepository;
import com.experisproject.experisproject.models.security.jwt.JwtProvider;
import com.experisproject.experisproject.models.security.services.UsersDetailsServiceImpl;
import com.experisproject.experisproject.services.FavouriteListService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthRestAPI {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersDetailsServiceImpl usersDetailsService;
	@Autowired
	FavouriteListService favouriteListService;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest, HttpServletResponse response) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUserName(),
						loginRequest.getPassword()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication); //email, userId, isAdmin

		String role;
		if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			role = "admin";
		} else {
			role = "user";
		}
		Users user = usersRepository.findByUserName(loginRequest.getUserName()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not found."));;
		HttpHeaders header = new HttpHeaders();
		header.add("role",role);
		header.add("id",Integer.toString(user.getUserId()));
		header.add("userName",user.getUserName());
		return ResponseEntity.ok().headers(header).body(new JwtResponse(jwt));
	}

	@RequestMapping(value = "/signup",method= RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Response> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (usersRepository.existsByUserName(signUpRequest.getUserName())) {

			Response response = new Response("Username is already taken!");
			response.setItem("userName");
			return new ResponseEntity<Response>(response,
					HttpStatus.BAD_REQUEST);
		}

		if (usersRepository.existsByEmail(signUpRequest.getEmail())) {
			Response response = new Response("Email is already in use!");
			response.setItem("email");
			return new ResponseEntity<Response>(response,
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Users user = new Users(signUpRequest.getUserName(),
				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
		FavouriteList favouriteList = new FavouriteList(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), user);
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Cause: User Role not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Cause: User Role not found."));
					roles.add(userRole);
			}
		});
		user.setRoles(roles);
		usersRepository.save(user);
		favouriteListService.save(favouriteList);
		Response response = new Response("User registered successfully!");
		return ResponseEntity.ok().body(response);
	}
}