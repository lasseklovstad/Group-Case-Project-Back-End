package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT u.userId, u.userName, u.email FROM User u")
	List<User> findUsersIdUsernameEmail();

	Boolean existsByEmail(String email);

	User findByEmail(String email);
}
