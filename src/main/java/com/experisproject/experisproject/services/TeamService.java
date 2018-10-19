package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    @Autowired
    public TeamRepository teamRepository(TeamRepository teamRepository){
        return this.teamRepository=teamRepository;
    }

    public void save(Team team){
        teamRepository.save(team);
    }

    public Team findById(int id){
        return teamRepository.findById(id).get();
    }
    public void deleteAll(){teamRepository.deleteAll();}

}
