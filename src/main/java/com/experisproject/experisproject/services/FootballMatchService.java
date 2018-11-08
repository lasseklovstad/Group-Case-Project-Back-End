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
	public List<FootballMatch> findFootballMatchIdDateSeasonLocationTeamsPlayers(){
		return footballMatchRepository.findFootballMatchIdDateSeasonLocationTeamsPlayers();
	}


	public FootballMatch findById(int id){
		return footballMatchRepository.findById(id).get();
	}

	public 	List<FootballMatch> findFootballMatchesResult(){
		return footballMatchRepository.findFootballMatchesResult();
	}

	public void updateFootballMatch(FootballMatch footballMatch){
		save(footballMatch);
	}

	public void save(FootballMatch footballMatch){
		footballMatchRepository.save(footballMatch);
	}

	public void deleteById(int id) {
		footballMatchRepository.deleteById(id);
	}
	public void deleteAll(){
		footballMatchRepository.deleteAll();
	}


}
