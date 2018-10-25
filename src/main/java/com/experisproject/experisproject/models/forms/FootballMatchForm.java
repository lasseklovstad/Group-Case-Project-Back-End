package com.experisproject.experisproject.models.forms;

import com.experisproject.experisproject.models.entities.*;

import java.time.LocalDate;
import java.util.List;

public class FootballMatchForm {

	//footballMatch
	private LocalDate matchDate;

	//Season
	private String seasonName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String seasonDescription;

	//Location
	private String locationName;
	private String locationDescription;
	//address


	//Team hometeam
	private String homeTeamName;
	private Association homeTeamAssociation;
	private Owner homeTeamOwner;
	private Coach homeTeamCoach;
	private Location homeTeamLocation;


	//Team awayTeam
	private String awayTeamName;
	private Association awayTeamAssociation;
	private Owner awayTeamOwner;
	private Coach awayTeamCoach;
	private Location awayTeamLocation;


	List<Player> players;







}
