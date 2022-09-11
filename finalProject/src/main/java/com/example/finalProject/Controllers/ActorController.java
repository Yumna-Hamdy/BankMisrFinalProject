package com.example.finalProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Services.ActorService;

@RestController
@RequestMapping("/Actor")
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
	
}