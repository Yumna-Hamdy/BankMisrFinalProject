package com.example.finalProject.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.finalProject.Entities.Movie;



public interface movieRepository extends JpaRepository<Movie, Integer>{
	public List<Movie> findByMovieNameContainingIgnoreCase(String name);
	public List<Movie> findByCategory(String name);
	String queryString = "Select a.actor_id as actorId, a.actor_name as actorName,a.actor_image_path as "
			+ "actorImagePath from actor_movies am ,"
			+ "movie m,actor a where  a.actor_id = am.actor_id and m.movie_id = am.movie_id and m.movie_id = ?1";

	@Query(value = queryString,nativeQuery = true)
	public List<actorInterface> getMovieById(int id);
	 public List<Movie> findByOrderByReleasedYearAsc();
	 
	 @Query(value = "SELECT count(*) from movie_user_rating where movie_id = ?1",
				nativeQuery = true)
		Float getCountofUsersRatedThisMovie(int movie_id);
		
		@Query(value = "SELECT sum(rating) from movie_user_rating where movie_id = ?1",nativeQuery = true)
		Float getSumofUserRatings(int movie_id);
		
		@Query(value = "SELECT rating from movie_user_rating where movie_id = ?1 and user_id = ?2",nativeQuery = true)
		Integer isUserRatingPresent(int movie_id,int user_id);
		
		
		@Modifying
		@Transactional
		@Query(value = "Update movie_user_rating  set rating =?1 where movie_id =?2 and user_id =?3",nativeQuery = true)
		Integer updateRating(int rating,int movie_id,int user_id);
		
		@Modifying
		@Transactional
		@Query(value = "Insert into movie_user_rating values(?1,?2,?3)",nativeQuery = true)
		void InsertRating(int movie_id,int user_id,int rating);
}