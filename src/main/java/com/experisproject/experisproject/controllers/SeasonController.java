package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Season;
import com.experisproject.experisproject.models.forms.SeasonForm;
import com.experisproject.experisproject.projections.SeasonLimited;
import com.experisproject.experisproject.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void createNew(@RequestBody SeasonForm form){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dtf=dtf.withLocale(Locale.US);
        Season season = new Season(form.getName(),LocalDate.parse(form.getStartDate(),dtf),LocalDate.parse(form.getEndDate(),dtf),form.getDescription());
        seasonService.save(season);
    }
}
