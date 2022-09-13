package com.example.finalProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.Entities.MovieUserRating;

public interface MovieUserRatingRepository extends JpaRepository<MovieUserRating, Integer>{

	//MovieUserRating findBymovieIdanduserId(int mid, int uid);

	//MovieUserRating findBymIdAnduId(int mid, int uid);

	//MovieUserRating findByMovieIdAndUserId(int mid, int uid);

}
