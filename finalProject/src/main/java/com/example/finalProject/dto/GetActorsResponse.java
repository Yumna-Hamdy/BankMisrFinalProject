package com.example.finalProject.dto;

import java.util.List;

public class GetActorsResponse {
	private List<MovieDto>movies;
	private int actorId;
	private String actorName;
	private String actorImagePath;
	
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorImagePath() {
		return actorImagePath;
	}
	public void setActorImagePath(String actorImagePath) {
		this.actorImagePath = actorImagePath;
	}
	public List<MovieDto> getMovies() {
		return movies;
	}
	public void setMovies(List<MovieDto> movies) {
		this.movies = movies;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
}
