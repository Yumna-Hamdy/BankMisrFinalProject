package com.example.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Repositories.tempInterface;
import com.example.finalProject.Services.ActorService;

@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

public class ActorController {  //Actor Controller is redundant but for testing
	@Autowired
	public ActorService actorService;
	
	@PostMapping(value = "/add")
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	
	@GetMapping(value = {"/{name}"})
	public Actor getbyName(@PathVariable String name) {
		return actorService.getActorByName(name);
	}
	@GetMapping(value = "/getActors")
	public List<Actor> getAllActors(){
		return actorService.getActorsList();
	}
	// find movies the actor participated in by actor id
	@GetMapping(value= {"/actorMovies/{id}"})
	public List<tempInterface> getActorMovies(@PathVariable int id){
		return actorService.getActorMovies(id);
	}
	
}
