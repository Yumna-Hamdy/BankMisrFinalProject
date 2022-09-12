package com.example.finalProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
