package com.example.finalProject.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.actorInterface;
import com.example.finalProject.Repositories.movieRepository;

@Service
public class movieService {
	@Autowired
	movieRepository movieRepository;
	public Movie addMovie(Movie t) {
		return movieRepository.save(t);
	}
	
	public Movie getByID(int id) {
		return movieRepository. findById(id).get();
		// list<Obj[]> 
	}
	
	public List<Movie> getByName(String name) {
		return movieRepository.findByMovieNameContainingIgnoreCase( name);
	}
	
	public List<Movie> getByCategory(String name) {
		return movieRepository.findByCategory( name);
	}
	
	
}
