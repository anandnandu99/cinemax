package com.hexaware.cinemax.controllers;

import com.hexaware.cinemax.dto.MovieDTO;
import com.hexaware.cinemax.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    // Add a new movie
    @PostMapping("/addMovie")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO createdMovie = movieService.addMovie(movieDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    // Get all movies
    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // Remove a movie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMovie(@PathVariable int id) {
        movieService.removeMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Remove a movie by name
    @DeleteMapping("/removeByName/{name}")
    public ResponseEntity<Void> removeMovieByName(@PathVariable String name) {
        movieService.removeMovieByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
