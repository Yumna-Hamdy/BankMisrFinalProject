package com.example.finalProject.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.ActorRepository;
import com.example.finalProject.Repositories.actorInterface;
import com.example.finalProject.Repositories.movieRepository;
import com.example.finalProject.dto.ActorDto;
import com.example.finalProject.dto.GetMoviesResponse;

@Service
public class movieService {
	@Autowired
	movieRepository movieRepository;
	@Autowired 
	ActorRepository actorRepository;
	
	public Movie addMovie(Movie t) {
		return movieRepository.save(t);
	}
	///////////////////To return actors array in the movie object///////////////////////////////////////////////
	public GetMoviesResponse getByID(int id) {
		Movie movie =movieRepository. findById(id).get();
		List<Actor> actors= actorRepository.findAll();
		return mapToMovieResponse(movie,  actors);
		 
	}
	
	public GetMoviesResponse mapToMovieResponse(Movie movie,  List<Actor> actors)
	{
		GetMoviesResponse getMoviesResponse=new GetMoviesResponse();
		
		getMoviesResponse.setActors(mapToActorDto(actors));
		getMoviesResponse.setMovieName(movie.getMovieName());
		return getMoviesResponse;
	}
	
	public  List<ActorDto> mapToActorDto(List<Actor> actors)
	{
		List<ActorDto> actorDtoList = new ArrayList<>();
		
		for(int i=0; i<actors.size(); i++)
		{
			ActorDto actorDto= new ActorDto();
			actorDto.setActorName(actors.get(i).actorName);
			actorDtoList.add(actorDto);
		}
		return actorDtoList;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	}
	public List<Movie> getByName(String name) {
		return movieRepository.findByMovieNameContainingIgnoreCase( name);
	}
	
	public List<Movie> getByCategory(String name) {
		return movieRepository.findByCategory( name);
	}
	public List<Movie> getMovieList(){
		return movieRepository.findByOrderByReleasedYearAsc();
	}
	
}
