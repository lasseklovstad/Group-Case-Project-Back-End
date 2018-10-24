package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Season;
import com.experisproject.experisproject.models.repositories.SeasonRepository;
import com.experisproject.experisproject.projections.SeasonLimited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SeasonService {
    private SeasonRepository seasonRepository;

    @Autowired
    SeasonRepository seasonRepository(SeasonRepository seasonRepository){
        return this.seasonRepository=seasonRepository;
    }

    public void save(Season season){
        seasonRepository.save(season);
    }

    public List<SeasonLimited> findAllLimited(){
        return seasonRepository.findAllLimited();
    }
}