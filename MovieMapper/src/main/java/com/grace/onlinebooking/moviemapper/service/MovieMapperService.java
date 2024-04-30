package com.grace.onlinebooking.moviemapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grace.onlinebooking.moviemapper.dao.MovieMapperRepository;
import com.grace.onlinebooking.moviemapper.model.MovieMapper;


@Service
public class MovieMapperService {

    @Autowired
    private MovieMapperRepository movieMapperRepository;

    public void assignMovie(int movieId, int showId, int theatreId) {
        // Check if the assignment already exists
        if (movieMapperRepository.existsByMovieIdAndShowIdAndTheatreId(movieId, showId, theatreId)) {
            throw new IllegalArgumentException("Duplicate assignment: Movie already assigned to this show in this theater");
        }

        // If not duplicate, save the assignment
        MovieMapper movieMapper = new MovieMapper();
        movieMapper.setMovieId(movieId);
        movieMapper.setShowId(showId);
        movieMapper.setTheatreId(theatreId);
        movieMapperRepository.save(movieMapper);
    }
    public List<MovieMapper> getMoviesByMovieId(int movieId) {
    	System.out.println("In service layer ::::"+movieId);
        return movieMapperRepository.findByMovieId(movieId);	
    }
	public void deleteMappingByShowId(int showId) {
		 System.out.println("*********** entered  Service layer***********");
		movieMapperRepository.deleteById(showId);
	}
	
	
	
    
}