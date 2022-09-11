package com.example.finalProject.Repositories;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.Entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

	Actor findByactorNameContainingIgnoreCase(String name);
	
	@org.springframework.data.jpa.repository.Query(value = "Select a from Actor a")
	public List<Actor> getActorsList();
	
	String queryString = "Select m.movie_id as movieId,m.movie_name as movieName from actor_movies am ,movie m,actor a where a.actor_id = ?1 "
			+ "and a.actor_id = am.actor_id and m.movie_id = am.movie_id";
	@org.springframework.data.jpa.repository.Query(value = queryString , 
			nativeQuery = true)
	List<tempInterface> getActorMovies(int id);
}
