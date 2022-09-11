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
public class MovieCategoriesId implements Serializable{

	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie1;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Movie getMovie() {
		return movie1;
	}

	public void setMovie(Movie movie) {
		this.movie1 = movie;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
