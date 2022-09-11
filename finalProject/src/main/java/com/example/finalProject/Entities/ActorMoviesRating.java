package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ActorMoviesRating {
	@EmbeddedId
	public ActorMoviesId Id;
	
	private int rating;

	public int getRating() {
		if (rating > 5 || rating < 0) {
			return -1; //-1 is a flag that indicates that the entered rating is wrong
		}
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	} 
	
	
}
