package com.experisproject.experisproject.projections;

public interface OwnerLimited {
	int getOwnerId();
	PersonLimited getPerson();
	TeamLimited getTeam();

}
