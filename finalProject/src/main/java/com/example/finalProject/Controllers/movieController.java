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
import com.example.finalProject.dto.GetMoviesResponse;



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
	@GetMapping("/getRating/{movie_id}")
	public Float getMovieRating(@PathVariable  int movie_id) {
		return movieService.getRatingofMovie(movie_id);
	}
	@GetMapping("/getSum/{movie_id}")
	public Float get(@PathVariable  int movie_id) {
		return movieService.getSumOfUserRatings(movie_id);
	}
	
	//@GetMapping("/rateMovie/{mid}/")
	@GetMapping("rateMovie/{mid}/{uid}/{rating}")
	public Float mvRating(@PathVariable int mid,@PathVariable int uid,@PathVariable int rating) {
		
		return movieService.rateMovie(mid,uid,rating);
}
}
