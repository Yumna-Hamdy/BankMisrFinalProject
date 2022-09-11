package com.example.finalProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.Entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

	Actor findByactorName(String name);


}
