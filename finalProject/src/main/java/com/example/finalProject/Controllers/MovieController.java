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
	
}
