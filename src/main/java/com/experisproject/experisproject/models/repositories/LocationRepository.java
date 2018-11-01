package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.projections.LocationLimited;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query(value = "SELECT l.locationId, l.name, l.description, l.address.addressId, CONCAT(l.address.addressLine1,', ' ,l.address.city,', ', l.address.country), l.team.teamId, l.team.name FROM Location l")
	List<Location> findLocationIdNameDescriptionAddress();

	@Query(value = "SELECT l FROM Location l")
	List<LocationLimited> findAllLimited();

	Location findByName(String name);
}
