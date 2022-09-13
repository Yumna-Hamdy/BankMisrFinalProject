package com.example.finalProject.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
}
