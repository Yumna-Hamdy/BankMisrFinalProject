package com.example.finalProject.Services;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Repositories.ActorRepository;

@Service
public class ActorService {  // all actor 
	@Autowired
	public ActorRepository actorRepository;

	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	public Actor getActorByName(String name) {
		return actorRepository.findByactorNameContainingIgnoreCase(name);
	}
	
	// find actor movies by actor id
	public List<Actor> getActorsList(){
		return actorRepository.getActorsList();
	}
	
}
