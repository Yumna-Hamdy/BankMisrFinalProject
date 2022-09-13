package com.example.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Entities.Category;
import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Entities.MovieUserRating;
import com.example.finalProject.Repositories.MovieRepository;
import com.example.finalProject.Repositories.projectionCategoryInterface;
import com.example.finalProject.Services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	public MovieService movieService;
	
	@PostMapping("/add")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@GetMapping("/categories/"
			+ "{movieId}")
	public List<projectionCategoryInterface> getCategories(@PathVariable int movieId) {
		return movieService.getCategory(movieId);
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
	@GetMapping("rateMovie/{mid}/{uid}")
	public Float mvRating(@PathVariable int mid,@PathVariable int uid,int rating) {
		return movieService.rateMovie(mid,uid,rating);
	}

}
