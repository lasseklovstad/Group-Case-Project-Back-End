package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.projections.LocationLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    @Query(value = "SELECT l FROM Location l")
    List<LocationLimited> findAllLimited();
}
