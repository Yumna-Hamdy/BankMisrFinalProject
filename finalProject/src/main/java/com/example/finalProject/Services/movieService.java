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
		getMoviesResponse.setDirectorName(movie.getDirectorName());
		getMoviesResponse.setImage(movie.getImage());
		getMoviesResponse.setCategory(movie.getCategory());
		getMoviesResponse.setVideo(movie.getVideo());
		getMoviesResponse.setDescription(movie.getDescription());
		getMoviesResponse.setReleasedYear(movie.getReleasedYear());
		getMoviesResponse.setAddedDate(movie.getAddedDate());
		getMoviesResponse.setTime(movie.getTime());
		getMoviesResponse.setAge(movie.getAge());
		
		return getMoviesResponse;
	}
	
	public  List<ActorDto> mapToActorDto(List<Actor> actors)
	{
		List<ActorDto> actorDtoList = new ArrayList<>();
		
		for(int i=0; i<actors.size(); i++)
		{
			ActorDto actorDto= new ActorDto();
			actorDto.setActorName(actors.get(i).actorName);
			actorDto.setActorImagePath(actors.get(i).actorImagePath);
			actorDto.setActorId(actors.get(i).actorId);
			actorDtoList.add(actorDto);
		}
		return actorDtoList;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	}
	public List<Movie> getByName(String name) {
		return movieRepository.findByMovieNameContainingIgnoreCase( name);
	}
	
	public List<Movie> getByCategory(String name) {
		return movieRepository.findByCategoryContainingIgnoreCase( name);
	}
	public List<Movie> getMovieList(){
		return movieRepository.findByOrderByReleasedYearAsc();
	}
	// put rating to the movie 
		// Select if null get count of user ratings
		// add rating and sum rating
		public Float getRatingofMovie(int movie_id) {
			//Integer isPresent = movieRepository.isUserRatingPresent(movie_id, user_id)
			Float ratingCount =  movieRepository.getCountofUsersRatedThisMovie(movie_id);
			//if (rating)
			Float sumRating = 	movieRepository.getSumofUserRatings(movie_id);
			Float average = (Float) sumRating/(Float) ratingCount;
			return average;
			//getSumofRatingsOfUsers();
		}
		
		public Float rateMovie(int movie_id,int user_id,int rating) {
			Integer isPresent = movieRepository.isUserRatingPresent(movie_id, user_id);
			if (isPresent == null) {
				//return (float) 13.0;
				movieRepository.InsertRating(movie_id, user_id, rating);
			}
			else {
				Integer into = movieRepository.updateRating(rating, movie_id,user_id);
			}
			return getRatingofMovie(movie_id);
		}
		
		public Float getSumOfUserRatings(int movie_id) {
			return movieRepository.getSumofUserRatings(movie_id);
		}
}
