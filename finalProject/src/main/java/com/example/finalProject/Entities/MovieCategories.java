package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MovieCategories {
	@EmbeddedId
	public MovieCategoriesId movieCategoriesId;
	
}
