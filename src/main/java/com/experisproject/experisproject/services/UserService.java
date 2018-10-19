package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.User;
import com.experisproject.experisproject.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserRepository userRepository(UserRepository userRepository) {
		return this.userRepository = userRepository;
	}

	public List<User> findAll() {
		Iterable<User> users = this.userRepository.findAll();
		List<User> result = new ArrayList<>();

		for (User user : users) {
			result.add(user);
		}
		return result;
	}

	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}


}
