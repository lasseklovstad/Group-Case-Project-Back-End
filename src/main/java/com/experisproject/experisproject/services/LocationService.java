package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.models.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    LocationRepository locationRepository;
    @Autowired
    LocationRepository locationRepository(LocationRepository locationRepository){
        return this.locationRepository=locationRepository;
    }

    public void save(Location location){
        locationRepository.save(location);
    }
}
