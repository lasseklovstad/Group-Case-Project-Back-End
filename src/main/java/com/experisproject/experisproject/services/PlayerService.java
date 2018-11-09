package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.repositories.PlayerRepository;
import com.experisproject.experisproject.projections.PlayerLimited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerRepository playerRepository(PlayerRepository playerRepository){
        return this.playerRepository=playerRepository;
    }

    public List<Player> findAll(){
        List<Player> result = new ArrayList<>();
        playerRepository.findAll().forEach(player->result.add(player));
        return result;
    }
	public Player findById(int id){return playerRepository.findById(id).get();}

	public List<Player> findPlayerByTeamName(String teamName){
		return playerRepository.findPlayerByTeam_NameContaining(teamName);
	}

	public List<Player> findPlayersByTeamId(int id){
    	return playerRepository.findByTeamId(id);
	}

	public List<Player> findPlayerShortInfo(){
		return playerRepository.findPlayerShortInfo();
	}

	public List<PlayerLimited> findAllLimited(){
    	return playerRepository.findAllLimited();
	}

	public void updatePlayer(Player player){
    	playerRepository.save(player);
	}
	public void save(Player player){
        playerRepository.save(player);
    }
	public void deleteById(int id){
    	playerRepository.deleteById(id);
	}
    public void deleteAll(){playerRepository.deleteAll();}


}
