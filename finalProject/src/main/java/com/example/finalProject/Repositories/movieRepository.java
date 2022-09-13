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
}