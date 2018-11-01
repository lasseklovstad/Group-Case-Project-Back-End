package com.experisproject.experisproject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class FootballMatch {
	@Id
	@GeneratedValue
	private int footballMatchId;

	@NotNull
	private LocalDate matchDate;

	@ManyToOne
	@JoinColumn(name = "seasonId")
	@NotNull
	private Season season;

	@ManyToOne
	@JoinColumn(name = "locationId")
	@NotNull
	private Location location;

	@ManyToOne
	@JoinColumn(name = "homeTeam")
	@NotNull
	private Team homeTeam;

	@ManyToOne
	@JoinColumn(name = "awayTeam")
	@NotNull
	private Team awayTeam;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matchPosition",
			joinColumns = {@JoinColumn(name = "footballMatchId")},
			inverseJoinColumns = {@JoinColumn(name = "playerId")}
	)
	private Set<Player> players = new HashSet<>();

	public FootballMatch() {

	}

	public FootballMatch(@NotNull LocalDate matchDate, @NotNull Season season, @NotNull Location location, @NotNull Team homeTeam, @NotNull Team awayTeam, Set<Player> players) {
		this.matchDate = matchDate;
		this.season = season;
		this.location = location;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.players = players;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
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
