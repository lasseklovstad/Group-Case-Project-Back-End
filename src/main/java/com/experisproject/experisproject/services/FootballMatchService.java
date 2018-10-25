package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.repositories.FootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballMatchService {
	private FootballMatchRepository footballMatchRepository;

	@Autowired
	public FootballMatchRepository footballMatchRepository(FootballMatchRepository footballMatchRepository){
		return this.footballMatchRepository = footballMatchRepository;
	}

	public List<FootballMatch> findAll(){
		List<FootballMatch> result = new ArrayList<>();
		footballMatchRepository.findAll().forEach(footballMatch-> result.add(footballMatch));
		return result;
	}

	public FootballMatch findById(int id){
		return footballMatchRepository.getOne(id);
	}
/*
	public 	List<FootballMatch> findFootballMatchesResult(){
		return footballMatchRepository.findFootballMatchesResult();
	}
*/

	public void save(FootballMatch footballMatch){
		footballMatchRepository.save(footballMatch);
	}

	public void deleteAll(){
		footballMatchRepository.deleteAll();
	}


}
