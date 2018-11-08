package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query(value = "SELECT u.userId, u.userName, u.email FROM Users u")
	List<Users> findUsersIdUsernameEmail();

	Optional<Users> findByUserName(String userName);

	Boolean existsByUserName(String userName);

	Boolean existsByEmail(String email);

	Users findByEmail(String email);

	int findUsers_userIdByUserName(String userName);
}
