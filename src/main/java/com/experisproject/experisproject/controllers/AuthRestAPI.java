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

import javax.validation.Valid;

import com.experisproject.experisproject.message.request.LoginForm;
import com.experisproject.experisproject.message.request.SignUpForm;
import com.experisproject.experisproject.message.response.JwtResponse;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

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

		return ResponseEntity.ok().headers(header).body(new JwtResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (usersRepository.existsByUserName(signUpRequest.getUserName())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!",
					HttpStatus.BAD_REQUEST);
		}

		if (usersRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!",
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Users user = new Users(signUpRequest.getUserName(),
				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
		FavouriteList favouriteList = new FavouriteList(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), user);
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		System.out.println(strRoles);
		strRoles.forEach(role -> {
			switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
					roles.add(userRole);
			}
		});
		user.setRoles(roles);
		usersRepository.save(user);
		favouriteListService.save(favouriteList);

		return ResponseEntity.ok().body("User registered successfully!");
	}
}