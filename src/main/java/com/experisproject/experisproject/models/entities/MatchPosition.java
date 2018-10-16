package com.experisproject.experisproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchPosition {
	@Id
	private int playerId;
	private String position;

	//  position VARCHAR(64),
	//  player_id INT NOT NULL,
	//  match_id INT NOT NULL,
	//  PRIMARY KEY (player_id, match_id),
	//  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id),
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id)


}
