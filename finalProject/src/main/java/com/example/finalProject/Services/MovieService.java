package com.example.finalProject.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.Entities.Category;
import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.MovieRepository;
import com.example.finalProject.Repositories.projectionCategoryInterface;

@Service
public class MovieService {
	@Autowired
	public MovieRepository movieRepository;
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<projectionCategoryInterface> getCategory(int movieId) {
		//int movieId = movie.getMovieId();
		return movieRepository.getMovieCategories(movieId);
		//return new ArrayList<>(listObject);
//		Category c = new Category();
//		for (Object[] obj: listObject) {
//			
//		}
	}
	
	
	
}
