////package com.example.finalProject.Services;
////
////import java.util.List;
////
////import javax.management.Query;
////import javax.swing.SortOrder;
////
////import org.hibernate.annotations.SortType;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import org.springframework.web.bind.annotation.PostMapping;
////
////import com.example.finalProject.Entities.Actor;
////import com.example.finalProject.Repositories.ActorRepository;
////import com.example.finalProject.Repositories.tempInterface;
////
////import org.springframework.data.domain.Sort;
////
////
////
////
////@Service
////public class ActorService {  // all actor 
////	@Autowired
////	public ActorRepository actorRepository;
////
////	public Actor addActor(Actor actor) {
////		return actorRepository.save(actor);
////	}
////
////	public Actor getActorByName(String name) {
////		return actorRepository.findByactorNameContainingIgnoreCase(name);
////	}
////	
////	// find actor movies by actor id
////	public List<Actor> getActorsList(){
////		return actorRepository.getActorsList();
////	}
////	public List<tempInterface> getActorMovies(int id){
////		//return actorRepository.getActorMovies(id,Sort.by(Sort.Direction.ASC, "movieId"));
////		return actorRepository.getActorMovies(id);
////	}
////	
////}
//package com.example.finalProject.Services;
//
//import java.util.List;
//
//import javax.management.Query;
//import javax.swing.SortOrder;
//
//import org.hibernate.annotations.SortType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.finalProject.Entities.Actor;
//import com.example.finalProject.Repositories.ActorRepository;
//import com.example.finalProject.Repositories.tempInterface;
//
//import org.springframework.data.domain.Sort;
//
//
//
//
//@Service
//public class ActorService {  // all actor 
//	@Autowired
//	public ActorRepository actorRepository;
//
//	public Actor addActor(Actor actor) {
//		return actorRepository.save(actor);
//	}
//
//	public List<Actor> getActorByName(String name) {
//		return actorRepository.findByactorNameContainingIgnoreCase(name);
//	}
//	
//	// find actor movies by actor id
//	public List<Actor> getActorsList(){
//		return actorRepository.getActorsList();
//	}
//	public List<tempInterface> getActorMovies(int id){
//		//return actorRepository.getActorMovies(id,Sort.by(Sort.Direction.ASC, "movieId"));
//		return actorRepository.getActorMovies(id);
//	}
//
//	public Actor getActorById(int id) {
//		return actorRepository.findById(id).orElse(null);
//	}
//	
//}

package com.example.finalProject.Services;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.swing.SortOrder;

import org.hibernate.annotations.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Repositories.ActorRepository;
import com.example.finalProject.Repositories.movieRepository;
import com.example.finalProject.Repositories.tempInterface;
import com.example.finalProject.dto.ActorDto;
import com.example.finalProject.dto.GetActorsResponse;
import com.example.finalProject.dto.GetMoviesResponse;
import com.example.finalProject.dto.MovieDto;

import org.springframework.data.domain.Sort;




@Service
public class ActorService {  // all actor 
	@Autowired
	public ActorRepository actorRepository;
	@Autowired 
	public movieRepository movieRepository;

	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	public List<Actor> getActorByName(String name) {
		return actorRepository.findByactorNameContainingIgnoreCase(name);
	}
	
	// find actor movies by actor id
	public List<Actor> getActorsList(){
		return actorRepository.getActorsList();
	}
	public List<tempInterface> getActorMovies(int id){
		//return actorRepository.getActorMovies(id,Sort.by(Sort.Direction.ASC, "movieId"));
		return actorRepository.getActorMovies(id);
	}

	public Actor getActorById(int id) {
		return actorRepository.findById(id).orElse(null);
	}
	//////////////////////////////////////////////////////////////////////////
	public GetActorsResponse getByID(int id) {
		Actor actor =actorRepository. findById(id).get();
		List<Movie> movies= movieRepository.findAll();
		return mapToActorResponse(actor,  movies);
		 
	}
	
	public GetActorsResponse mapToActorResponse(Actor actor,  List<Movie> movies)
	{
		GetActorsResponse getActorsResponse=new GetActorsResponse();
		
		getActorsResponse.setMovies(mapToMovieDto(movies));
		getActorsResponse.setActorId(actor.getActorId());
		getActorsResponse.setActorImagePath(actor.getActorImagePath());
		getActorsResponse.setActorName(actor.getActorName());
		return getActorsResponse;
	}
	
	public  List<MovieDto> mapToMovieDto(List<Movie> movies)
	{
		List<MovieDto> movieDtoList = new ArrayList<>();
		
		for(int i=0; i<movies.size(); i++)
		{
			MovieDto movieDto= new MovieDto();
			movieDto.setMovieName(movies.get(i).getMovieName());
			movieDto.setImage(movies.get(i).getImage());
			movieDto.setMovieId(movies.get(i).getMovieId());
			movieDtoList.add(movieDto);

		}
		return movieDtoList;

	
}
}
