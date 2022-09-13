package com.example.finalProject.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.Entities.Category;
import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Entities.MovieUserRating;
import com.example.finalProject.Repositories.MovieRepository;
import com.example.finalProject.Repositories.MovieUserRatingRepository;
import com.example.finalProject.Repositories.projectionCategoryInterface;

@Service
public class MovieService {
	@Autowired
	public MovieRepository movieRepository;
	
	@Autowired
	public MovieUserRatingRepository movieUserRatingRepository;
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<projectionCategoryInterface> getCategory(int movieId) {
		return movieRepository.getMovieCategories(movieId);
//		}
	}
	// put rating to the movie 
	// Select if null get count of user ratings
	// add rating and sum rating
	public Float getRatingofMovie(int movie_id) {
		//Integer isPresent = movieRepository.isUserRatingPresent(movie_id, user_id)
		Float ratingCount =  movieRepository.getCountofUsersRatedThisMovie(movie_id);
		//if (rating)
		Float sumRating = 	movieRepository.getSumofUserRatings(movie_id);
		//Float average = (Float) sumRating/(Float) ratingCount;
		return ratingCount;
		//getSumofRatingsOfUsers();
	}
	
	public Float rateMovie(int movie_id,int user_id,int rating) {
		Integer isPresent = movieRepository.isUserRatingPresent(movie_id, user_id);
		if (isPresent == null) {
			return (float) 13.0;
		}
		else {
			movieRepository.updateRating(movie_id, user_id);
		}
		return getRatingofMovie(movie_id);
	}
	
	public Float getSumOfUserRatings(int movie_id) {
		return movieRepository.getSumofUserRatings(movie_id);
	}

//	public MovieUserRating findbymIdanduId(int mid,int uid) {
//		//return movieUserRatingRepository.findByMovieIdAndUserId(mid,uid);
//		MovieUserRating mur = movieRepository.isFound(mid,uid);
//		return mur;
//	}
	
	
	
}
