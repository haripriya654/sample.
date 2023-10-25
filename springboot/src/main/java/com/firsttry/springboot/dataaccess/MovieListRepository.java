package com.firsttry.springboot.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firsttry.springboot.model.Movie;

public interface MovieListRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findMoviesByActor(String name);
	

}
