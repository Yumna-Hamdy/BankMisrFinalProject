package com.example.finalProject.dto;

import java.sql.Date;
import java.util.List;

public class GetMoviesResponse {
 public List<ActorDto> getActors() {
		return actors;
	}
	public void setActors(List<ActorDto> actors) {
		this.actors = actors;
	}
private String movieName;
private String directorName;
private String category;
private String image;
private String video;
public String getVideo() {
	return video;
}
public void setVideo(String video) {
	this.video = video;
}
private String description;
private int releasedYear;
private Date addedDate;
private int time;
private String age;
private Float rating;
private int id;


 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Float getRating() {
	return rating;
}
public void setRating(Float rating) {
	this.rating = rating;
}
public String getAge() {
	return age;
}
public void setAge(String string) {
	this.age = string;
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
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}

private List<ActorDto>actors;
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}

 
}
