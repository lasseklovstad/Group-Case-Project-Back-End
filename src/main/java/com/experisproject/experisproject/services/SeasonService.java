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
	public List<Season> findSeasonsIdNameDatesDescription(){
    	return seasonRepository.findSeasonsIdNameDatesDescription();
	}

	public Season findById(int id){
    	return seasonRepository.findById(id).get();
	}

	public void updateSeason(Season season){
    	save(season);
	}

    public void save(Season season){
        seasonRepository.save(season);
    }

    public List<SeasonLimited> findAllLimited(){
        return seasonRepository.findAllLimited();
    }

	public void deleteById(int id){
		seasonRepository.deleteById(id);

	}

}
