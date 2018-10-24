package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.projections.LocationLimited;
import com.experisproject.experisproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/location")
@CrossOrigin
public class LocationController {
    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<LocationLimited> getAllLimited(){
        return locationService.findAllLimited();
    }

}
