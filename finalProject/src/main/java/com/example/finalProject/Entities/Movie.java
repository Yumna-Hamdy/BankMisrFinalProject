package com.example.finalProject.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
	
	
	@OneToMany(mappedBy = "actor")
	List<ActorMoviesRating> actorMoviesRating;
}
