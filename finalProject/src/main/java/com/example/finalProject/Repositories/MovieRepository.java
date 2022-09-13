package com.example.finalProject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.finalProject.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	//SELECT b, p FROM Book b, Publisher p WHERE b.fk_publisher = p.id
	@Query(value = "Select c.id as id,c.cat_name as catName from category c,movie m , movie_categories mc where m.movie_id = ?1"
			+ " and m.movie_id = mc.movie_id and c.id = mc.category_id",nativeQuery = true)
	List<projectionCategoryInterface> getMovieCategories(int id);  // do not forget getCategoryMovies
	// movieCategoryInterface
}
