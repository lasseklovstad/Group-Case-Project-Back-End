package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.FootballMatch;
import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.repositories.FootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public List<Object> findPlayersByFootballMatchId(int footballMatchId){
		Set<Player> playerSet = footballMatchRepository.findPlayersByFootballMatchId(footballMatchId);
		List<Object> playerList = new ArrayList<>();
		String firstName;
		String lastName;
		System.out.println(playerSet.toString());

		for (Player player : playerSet) {
			playerList.add(player.getPlayerId());
			firstName = player.getPerson().getFirstName();
			lastName = player.getPerson().getLastName();
			System.out.println(firstName + lastName);

			playerList.add(firstName + " " + lastName);
		}
		System.out.println(playerList);

		return playerList;
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
