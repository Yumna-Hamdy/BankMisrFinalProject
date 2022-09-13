package com.example.finalProject.Entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;



@Entity
@Data
@Table(name = "movie")
public class Movie {
	@Id
    @GeneratedValue
    @Column(name="movie_id")
    private int movieId;
	
	public Movie(int movieId, String movieName, String directorName, String category, String image, String description,
			int releasedYear) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.directorName = directorName;
		this.category = category;
		this.image = image;
		this.description = description;
		this.releasedYear = releasedYear;
	}


	

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(int movieId, String movieName, String directorName, String category, String image, String video,
			String description, int releasedYear, Date addedDate, int time, Set<filmRating> rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.directorName = directorName;
		this.category = category;
		this.image = image;
		this.video = video;
		this.description = description;
		this.releasedYear = releasedYear;
		this.addedDate = addedDate;
		this.time = time;
		this.rating = rating;
	}




	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getDirectorName() {
		return directorName;
	}


	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getReleasedYear() {
		return releasedYear;
	}


	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}


	@Column(name = "name", nullable = true)
    private String movieName;
	
	@Column(name = "director", nullable = true)
    private String directorName;
	
	@Column(name = "category", nullable = true)
    private String category;
	
	@Column(name = "image", nullable = true)
    private String image;
	
	@Column(name = "video", nullable = true)
    private String video;
	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	@Column(name = "description", nullable = true)
    private String description;
	

	@Column(name = "year", nullable = true)
    private int releasedYear;
	
	@Column(name = "date", nullable = true)
    private Date addedDate;
	
	@Column(name = "Time", nullable = true)
    private int time;
	
	@OneToMany(mappedBy = "movie")
   Set<filmRating> rating;

	
}
//	@OneToMany(mappedBy = "movie")
//	List<ActorMoviesRating> actorMoviesRating;

