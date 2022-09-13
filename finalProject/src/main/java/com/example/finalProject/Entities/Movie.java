package com.example.finalProject.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Movie {
	@Id
	@GeneratedValue
	public int movieId;
	public String movieName;
	public String director;
	//public int time;
	public int year;
	public String description;
	public String image;
	public String video;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

//	@OneToMany(mappedBy = "movie")
//	List<ActorMoviesRating> actorMoviesRating;
}
