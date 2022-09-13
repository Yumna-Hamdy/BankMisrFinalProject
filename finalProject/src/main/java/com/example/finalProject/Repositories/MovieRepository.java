package com.example.finalProject.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.finalProject.Entities.Movie;
import com.example.finalProject.Entities.MovieUserRating;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	//SELECT b, p FROM Book b, Publisher p WHERE b.fk_publisher = p.id
	@Query(value = "Select c.id as id,c.cat_name as catName from category c,movie m , movie_categories mc where m.movie_id = ?1"
			+ " and m.movie_id = mc.movie_id and c.id = mc.category_id",nativeQuery = true)
	List<projectionCategoryInterface> getMovieCategories(int id);  // do not forget getCategoryMovies
	// movieCategoryInterface
	
	@Query(value = "SELECT count(*) from movie_user_rating where movie_id = ?1",
			nativeQuery = true)
	Float getCountofUsersRatedThisMovie(int movie_id);
	
	@Query(value = "SELECT sum(rating) from movie_user_rating where movie_id = ?1",nativeQuery = true)
	Float getSumofUserRatings(int movie_id);
	
	@Query(value = "SELECT rating from movie_user_rating where movie_id = ?1 and user_id = ?2",nativeQuery = true)
	Integer isUserRatingPresent(int movie_id,int user_id);
	
	
	@Modifying
	@Transactional
	@Query(value = "Update movie_user_rating  set rating =?1 where movie_id =?2 and user_id =?3",nativeQuery = true)
	Integer updateRating(int rating,int movie_id,int user_id);
	
	
	@Query(value = "Insert into movie_user_rating values(?1,?2,?3)",nativeQuery = true)
	void InsertRating(int movie_id,int user_id,int rating);
	
//	@Query(value = "Select mur from movie_user_rating mur where mId= ?1 and uId = ?2"  )
//	MovieUserRating isFound(int mid, int uid);
}
