package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.models.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachService {
    CoachRepository coachRepository;

    @Autowired
    CoachRepository coachRepository(CoachRepository coachRepository){
        return this.coachRepository=coachRepository;
    }

    public List<Coach> findAll(){
		List<Coach> result = new ArrayList<>();
		coachRepository.findAll().forEach(coach -> result.add(coach));
		 return result;
	}

    public void save(Coach coach){
        coachRepository.save(coach);
    }
    public void deleteAll(){coachRepository.deleteAll();}
}
