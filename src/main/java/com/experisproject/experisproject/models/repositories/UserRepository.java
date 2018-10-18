package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
