package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Owner;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {

}
