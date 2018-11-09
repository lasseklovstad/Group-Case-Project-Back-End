package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.FavouriteList;
import com.experisproject.experisproject.models.repositories.FavouriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteListService {


		private FavouriteListRepository favouriteListRepository;

		@Autowired
		public FavouriteListRepository favouriteListRepository(FavouriteListRepository favouriteListRepository){
			return this.favouriteListRepository = favouriteListRepository;
		}

		public List<FavouriteList> findFavouriteLists(){
			return favouriteListRepository.findFavouriteLists();
		}


		public List<FavouriteList> findAll(){
			return favouriteListRepository.findAll();
		}

		public FavouriteList findById(int id){
			return favouriteListRepository.findById(id).get();
		}

		public List<FavouriteList> findFavouriteListByUserId(int userId){
			return favouriteListRepository.findFavouriteListByUserId(userId);
		}


		public FavouriteList findFavouriteListByUserIdGenerated(int userId){
			return 	favouriteListRepository.findFavouriteListByUsers_UserId(userId);

		}

		public void updateFavouriteList(FavouriteList favouriteList){
			save(favouriteList);
		}

		public void save(FavouriteList favouriteList){
			favouriteListRepository.save(favouriteList);
		}

		public void deleteById(int id){
			favouriteListRepository.deleteById(id);
		}
	}

