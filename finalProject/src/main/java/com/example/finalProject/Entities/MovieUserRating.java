package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieUserRating {
	@EmbeddedId
	public MovieUserRatingId movieUserRatingId;
	
	public int rating;
	@ManyToOne
	@MapsId("mId")
	@JoinColumn(name = "movieId")
	public Movie movie2;	
	
	@ManyToOne
	@MapsId("uId")
	@JoinColumn(name = "userId")
	public User user;

	public Movie getMovie2() {
		return movie2;
	}

	public void setMovie2(Movie movie2) {
		this.movie2 = movie2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}