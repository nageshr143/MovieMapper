package com.grace.onlinebooking.moviemapper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.onlinebooking.model.Movie;
import com.grace.onlinebooking.moviemapper.model.MovieMapper;

@Repository//DB connection
public interface MovieMapperRepository extends JpaRepository<MovieMapper, Integer> {
	
	
	
	List<MovieMapper> findByMovieId(int movieId);

	boolean existsByMovieIdAndShowIdAndTheatreId(int movieId, int showId, int theatreId);


		
}

    
