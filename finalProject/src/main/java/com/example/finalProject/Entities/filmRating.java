package com.example.finalProject.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "filmRating")
class filmRating {

	
  @EmbeddedId
  public filmRatingKey id;

  @ManyToOne
  @MapsId("uId")
  @JoinColumn(name = "id")
  User user;

  @ManyToOne
  @MapsId("mId")
  @JoinColumn(name = "movieId")
  Movie movie;

   private int rating;
  
  // standard constructors, getters, and setters
}