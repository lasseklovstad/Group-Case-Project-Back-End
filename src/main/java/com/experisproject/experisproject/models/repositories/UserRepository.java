package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}
