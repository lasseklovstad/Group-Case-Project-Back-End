package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.FavouriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteListRepository extends JpaRepository<FavouriteList, Integer> {

	@Query(value = "SELECT fl.favouriteListId, fl.playerIds, fl.playerNames, fl.teamIds, fl.teamNames, fl.users.userId FROM FavouriteList fl ")
	List<FavouriteList> findFavouriteLists();

	@Query(value = "SELECT fl.favouriteListId, fl.playerIds, fl.playerNames, fl.teamIds, fl.teamNames, fl.users.userId FROM FavouriteList fl WHERE fl.users.userId = :userId")
	List<FavouriteList> findFavouriteListByUserId(@Param("userId") int userId);

	FavouriteList findFavouriteListByUsers_UserId(int userId);

}
