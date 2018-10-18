package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Player;
import com.experisproject.experisproject.models.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {
    private PlayerRepository repository;
    @Autowired
    public PlayerRepository playerRepository(PlayerRepository playerRepository){
        return this.repository=playerRepository;
    }


    public void addPlayer(Player player){

    }
}
