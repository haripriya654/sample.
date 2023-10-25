package com.firsttry.springboot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.firsttry.springboot.dataaccess.MovieListRepository;
import com.firsttry.springboot.model.Movie;

@Controller 
@RequestMapping("/")

public class MovieListController {
	
	@Autowired 
	private MovieListRepository movieListRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/movies/{actor}")
	public String getMovieListByActor(@PathVariable("actor")String name, Model model) {
		
		/*List<Movie> movieList= new ArrayList<Movie>();
		Movie movie = new Movie();
		movie.setActor("abc");
		movie.setDescription("ABC");
		movie.setName("123");
		movieList.add(movie);*/
		
		List<Movie> movieList = movieListRepository.findMoviesByActor(name);
		
		model.addAttribute("movies",movieList);
		
		return "movieList";
	}  

	@RequestMapping(method=RequestMethod.POST, value="/movies",consumes="application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
		
		movieListRepository.save(movie);
		return ResponseEntity.ok().build();
	}
   	
	
	
}
