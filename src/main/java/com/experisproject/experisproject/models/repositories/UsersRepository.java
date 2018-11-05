package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
		Optional<Users> findByUserName(String userName);
		Boolean existsByUserName(String userName);
		Boolean existsByEmail(String email);
}
