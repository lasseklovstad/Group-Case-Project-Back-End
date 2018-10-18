package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Coach;
import com.experisproject.experisproject.models.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    CoachRepository coachRepository;
    @Autowired
    CoachRepository coachRepository(CoachRepository coachRepository){
        return this.coachRepository=coachRepository;
    }
    public void save(Coach coach){
        coachRepository.save(coach);
    }
}
