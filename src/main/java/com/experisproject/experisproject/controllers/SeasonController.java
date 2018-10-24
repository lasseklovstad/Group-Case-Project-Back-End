package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.projections.SeasonLimited;
import com.experisproject.experisproject.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/season")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<SeasonLimited> getAllLimited(){
        return seasonService.findAllLimited();
    }
}
