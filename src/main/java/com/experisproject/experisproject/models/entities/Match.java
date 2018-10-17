package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Match {
	@Id
	@GeneratedValue
	private int matchId;

	private LocalDate matchDate;

	@ManyToOne
	@JoinColumn(name = "seasonId")
	private Season season;

	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team homeTeam;

	@ManyToOne
	@JoinColumn(name = "teamId", updatable = false, insertable = false)
	private Team awayTeam;

	@OneToMany(mappedBy = "match")
	private List<MatchPosition> matchpositions;

	public Match() {

	}

	public int getMatchId() {
		return matchId;
	}

	//  season_id INT NOT NULL,
	//  location_id INT NOT NULL,
	//  home_team_id INT NOT NULL,
	//  away_team_id INT NOT NULL,
	//  PRIMARY KEY (match_id),
	//  FOREIGN KEY (season_id) REFERENCES SEASON(season_id),
	//  FOREIGN KEY (home_team_id) REFERENCES TEAM(team_id),
	//  FOREIGN KEY (away_team_id) REFERENCES TEAM(team_id)
	//  FOREIGN KEY (location_id) REFERENCES LOCATION(location_id),


}
