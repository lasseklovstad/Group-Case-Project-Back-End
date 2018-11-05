package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Role;
import com.experisproject.experisproject.models.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleName roleName);

}
