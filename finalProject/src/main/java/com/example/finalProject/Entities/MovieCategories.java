package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieCategories {
	@EmbeddedId
	public MovieCategoriesId movieCategoriesId;
	
}
