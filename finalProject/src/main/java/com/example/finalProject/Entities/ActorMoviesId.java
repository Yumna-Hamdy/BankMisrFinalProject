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
	private int mId;
	private int aId;
//	@ManyToOne
//	@JoinColumn(name = "movieId")
//	public Movie movie;
//	
//	@ManyToOne
//	@JoinColumn(name = "actorId")
//	public Actor actor; //temporarily actor till user is completed
//
//	public Movie getMovie() {
//		return movie;
//	}
//
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}
//
//	public Actor getActor() {
//		return actor;
//	}
//
//	public void setActor(Actor actor) {
//		this.actor = actor;
//	}
//	
}
