package com.example.finalProject.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
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
	@OneToMany(mappedBy = "actor")
	List<ActorMoviesRating> actorMoviesRating;
}
