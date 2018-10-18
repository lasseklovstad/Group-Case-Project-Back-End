package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
