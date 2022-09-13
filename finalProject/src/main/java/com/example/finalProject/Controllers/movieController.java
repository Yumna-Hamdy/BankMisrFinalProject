package com.example.finalProject.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.actorInterface;
import com.example.finalProject.Services.movieService;



@RestController
@RequestMapping(value = "/movies")
public class movieController {
	@Autowired
	movieService movieService;
	@PostMapping
	public Movie addMovie(@RequestBody  Movie t) {		
		return movieService.addMovie(t);
	}
	@GetMapping(value = {"/{id}"})
	public Movie movieByID(@PathVariable int id){		
		return movieService.getByID(id);
		// list<Obj[]> = movie
	}
	
	@GetMapping(value = {"/name/{name}"})
	public List<Movie> movieByID(@PathVariable String name){		
		return movieService.getByName(name);
	}
	
	@GetMapping(value = {"/category/{name}"})
	public List<Movie> movieByCategroy(@PathVariable String name){		
		return movieService.getByCategory(name);
	} 
}
