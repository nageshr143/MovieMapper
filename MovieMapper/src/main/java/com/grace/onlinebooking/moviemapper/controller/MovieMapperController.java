package com.grace.onlinebooking.moviemapper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.grace.onlinebooking.moviemapper.model.MovieMapper;
import com.grace.onlinebooking.moviemapper.service.MovieMapperService;




@RestController
public class MovieMapperController {
	
	@Autowired 
	private MovieMapperService movieMapperService;
	@Autowired
    private RestTemplate restTemplate;
	
		
	  @PostMapping("/assignMovies") public ResponseEntity<String>
	  assignMovie(@RequestBody MovieMapperRequest request) {
	  
	  int movieId = request.getMovieId();
	  System.out.println("movieId::::"+movieId);
	  
	  int showId = request.getShowId(); 
	  System.out.println("showId::::"+showId);
	 
	  int theatreId = request.getTheatreId();
	  
	  System.out.println("theatreId::::"+theatreId);
	  
	  try { movieMapperService.assignMovie(movieId, showId, theatreId); return
	  ResponseEntity.ok("Movie assigned successfully"); } catch
	  (IllegalArgumentException e) { return
	  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); } }
	  
	  
	  @GetMapping(value="/getMovieTheatreShowDetails")
	    public List<MovieMapper> getMovie(@RequestParam String movieId) {
	    	System.out.println("movieName::::::"+movieId);
	    	int number = Integer.parseInt(movieId);
	    	return movieMapperService.getMoviesByMovieId(number);
	  	}
	  
	  
	  
	  
	  @DeleteMapping("/{showId}")
	    public ResponseEntity<Void> deleteMappingByShowId(@PathVariable int showId) {
		  System.out.println("*********** entered  Deleted***********");
	        movieMapperService.deleteMappingByShowId(showId);
	        return ResponseEntity.noContent().build();
	    }
	 
}
	