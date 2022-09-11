package com.example.finalProject.Repositories;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.Entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

	Actor findByactorNameContainingIgnoreCase(String name);
	
	@org.springframework.data.jpa.repository.Query("Select a from Actor a")
	public List<Actor> getActorsList();

}
