package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Watchlist;
import com.experisproject.experisproject.models.repositories.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

	private WatchlistRepository watchlistRepository;

	@Autowired
	public WatchlistRepository watchlistRepository(WatchlistRepository watchlistRepository){
		return this.watchlistRepository = watchlistRepository;
	}

	public List<Watchlist> findWatchlists(){
		return watchlistRepository.findWatchlists();
	}


	public List<Watchlist> findAll(){
		return watchlistRepository.findAll();
	}

	public Watchlist findById(int id){
		return watchlistRepository.findById(id).get();
	}

	public Watchlist findWatchListByUserId(int userId){
		return watchlistRepository.findWatchListByUserId(userId);
	}


	public Watchlist findWatchlistByUserIdGenerated(int userId){
		return 	watchlistRepository.findWatchlistByUser_UserId(userId);

	}

	public void updateWatchlist(Watchlist watchlist){
		save(watchlist);
	}

	public void save(Watchlist watchlist){
		watchlistRepository.save(watchlist);
	}

	public void deleteById(int id){
		watchlistRepository.deleteById(id);
	}
}
