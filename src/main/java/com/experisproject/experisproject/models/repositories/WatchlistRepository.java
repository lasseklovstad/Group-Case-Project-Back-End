package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {

	@Query(value = "SELECT w.watchlistId, w.playerIds, w.playerNames, w.teamIds, w.teamNames, w.user.userId FROM Watchlist w ")
	List<Watchlist> findWatchlists();

	@Query(value = "SELECT w.watchlistId, w.playerIds, w.playerNames, w.teamIds, w.teamNames, w.user FROM Watchlist w WHERE w.user.userId = :userId")
	Watchlist findWatchListByUserId(@Param("userId") int userId);

	Watchlist findWatchlistByUser_UserId(int userId);
}
