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

import java.util.List;

import javax.management.Query;
import javax.swing.SortOrder;

import org.hibernate.annotations.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.finalProject.Entities.Actor;
import com.example.finalProject.Repositories.ActorRepository;
import com.example.finalProject.Repositories.tempInterface;

import org.springframework.data.domain.Sort;




@Service
public class ActorService {  // all actor 
	@Autowired
	public ActorRepository actorRepository;

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
	
}
