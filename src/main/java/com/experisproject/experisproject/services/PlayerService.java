package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.entities.Team;
import com.experisproject.experisproject.models.repositories.PlayerRepository;
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

    public List<Player> findPlayerByTeamName(String teamName){
		return playerRepository.findPlayerByTeam_Name(teamName);
	}

	public List<Object> getPlayersName(){
    	return playerRepository.getPlayerName();
	}

    public void save(Player player){
        playerRepository.save(player);
    }
    public void deleteAll(){playerRepository.deleteAll();}
    public Player findById(int id){return playerRepository.findById(id).get();}

}
