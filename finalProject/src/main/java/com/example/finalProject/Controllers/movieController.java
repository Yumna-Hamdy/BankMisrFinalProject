package com.example.finalProject.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.actorInterface;
import com.example.finalProject.Services.movieService;
import com.example.finalProject.dto.GetMoviesResponse;



@RestController
@RequestMapping(value = "/movies")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

public class movieController {
	@Autowired
	movieService movieService;
	@PostMapping
	public Movie addMovie(@RequestBody  Movie t) {		
		return movieService.addMovie(t);
	}
	@GetMapping(value = {"/{id}"})
	public GetMoviesResponse movieByID(@PathVariable int id){		
		return movieService.getByID(id);
		
	}
	
	@GetMapping(value = {"/name/{name}"})
	public List<Movie> movieByName(@PathVariable String name){		
		return movieService.getByName(name);
	}
	
	@GetMapping(value = {"/category/{name}"})
	public List<Movie> movieByCategroy(@PathVariable String name){		
		return movieService.getByCategory(name);
	} 
	
	@GetMapping(value = {"/movieList"})
	public List<Movie> movieList(){		
		return movieService.getMovieList();
	} 
}
