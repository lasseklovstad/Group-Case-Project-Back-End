package com.experisproject.experisproject.models.entities;

import com.experisproject.experisproject.models.helpClasses.MatchPositionId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(MatchPositionId.class)
public class MatchPosition {

	@Id private int playerId; //maybe need to get from appropriate class as well?????
	@Id private int matchId; // google on how to set primary keys from other classes
	private String position;

	@ManyToOne
	@JoinColumn(name = "matchId", updatable = false, insertable = false)
	private FootballMatch footballMatch;

	@OneToOne
	@JoinColumn(name = "playerId", updatable = false, insertable = false)
	private Player player;

	public MatchPosition() {
	}

	//  position VARCHAR(64),
	//  player_id INT NOT NULL,
	//  match_id INT NOT NULL,
	//  PRIMARY KEY (player_id, match_id),
	//  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id),
	//  FOREIGN KEY (match_id) REFERENCES MATCH(match_id)
}
