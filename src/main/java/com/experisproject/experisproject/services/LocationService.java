package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.models.repositories.LocationRepository;
import com.experisproject.experisproject.projections.LocationLimited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
	LocationRepository locationRepository;

	@Autowired
	LocationRepository locationRepository(LocationRepository locationRepository) {
		return this.locationRepository = locationRepository;
	}

	public Location findById(int id) {
		return locationRepository.findById(id).get();
	}

	public List<LocationLimited> findAllLimited() {
		return locationRepository.findAllLimited();
	}

	public void save(Location location) {
		locationRepository.save(location);
	}

	public void deleteAll() {
		locationRepository.deleteAll();
	}
}
