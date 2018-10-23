package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.*;
import com.experisproject.experisproject.models.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public List<Team> findAll(){
        List<Team> result = new ArrayList<>();
        teamRepository.findAll().forEach(team->result.add(team));
        return result;
    }
    public List <Team> findAllByNameContaining(String name){
        return findAllByNameContaining(name);
    }

}
