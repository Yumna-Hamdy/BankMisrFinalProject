package com.example.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Repositories.tempInterface;
import com.example.finalProject.Services.ActorService;
import com.example.finalProject.dto.GetActorsResponse;
import com.example.finalProject.dto.GetMoviesResponse;

@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "*")
public class ActorController {  //Actor Controller is redundant but for testing
	@Autowired
	public ActorService actorService;
	
	@PostMapping(value = "/add")
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	
	@GetMapping(value = {"/name/{name}"})
	public List<Actor> getbyName(@PathVariable String name) {
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
	
	@GetMapping(value = {"/{id}"})
	public GetActorsResponse actorByID(@PathVariable int id){		
		return actorService.getByID(id);
		
	}
	
	
}
