package com.example.finalProject.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActorMoviesId implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	public Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "actorId")
	public Actor actor;
	
	
	
}
