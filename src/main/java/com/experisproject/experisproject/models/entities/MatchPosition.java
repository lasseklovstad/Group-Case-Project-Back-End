package com.experisproject.experisproject.models.entities;

import com.experisproject.experisproject.models.helpClasses.MatchPositionId;

import javax.persistence.*;

@Entity
@IdClass(MatchPositionId.class)
public class MatchPosition {

	@Id private int playerId; //maybe need to get from appropriate class as well?????
	@Id private int matchId; // google on how to set primary keys from other classes
	private String position;

	@ManyToOne
	@JoinColumn(name = "matchId")
	private Match match;

	@OneToOne
	@JoinColumn(name = "playerId")
	private Player player;


	//  position VARCHAR(64),
	//  player_id INT NOT NULL,
	//  match_id INT NOT NULL,
	//  PRIMARY KEY (player_id, match_id),
	//  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id),
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id)


}
