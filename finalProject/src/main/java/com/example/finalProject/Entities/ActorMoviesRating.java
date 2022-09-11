package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ActorMoviesRating {
	//@javax.persistence.Id
	@EmbeddedId
	public ActorMoviesId Id;	
	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if (rating > 5 || rating < 0) {
			return; //-1 is a flag that indicates that the entered rating is wrong
		}
		this.rating = rating;
	} 
}
