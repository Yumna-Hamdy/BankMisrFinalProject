package com.example.finalProject.Entities;

import java.io.Serializable;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.aspectj.lang.annotation.DeclareAnnotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Setter
@Getter
public class MovieUserRatingId implements Serializable{
	int mId;
	int uId;
	
//	@ManyToOne
//	@MapsId("mId")
//	@JoinColumn(name = "movieId")
//	public Movie movie2;	
//	
//	@ManyToOne
//	@MapsId("uId")
//	@JoinColumn(name = "userId")
//	public User user;
//
//	public Movie getMovie2() {
//		return movie2;
//	}
//
//	public void setMovie2(Movie movie2) {
//		this.movie2 = movie2;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
}
