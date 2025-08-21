package dev.paula.movie.controller;

import dev.paula.movie.repository.MovieCSVRepository;
import dev.paula.movie.singleton.MovieRepositorySingleton;

public class MovieController {
    
    private final MovieCSVRepository repository;
    
    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
    }
}
