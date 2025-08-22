package dev.paula.movie.controller;


import dev.paula.models.Emotion;
import dev.paula.movie.dtos.MovieDTO;
import dev.paula.movie.mappers.MovieMapper;
import dev.paula.movie.models.Movie;
import dev.paula.movie.repository.MovieCSVRepository;
import dev.paula.movie.service.MovieService;
import dev.paula.movie.singleton.MovieRepositorySingleton;

public class MovieController {
    
    private final MovieCSVRepository repository;
    private final MovieService apiService;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
        this.apiService = new MovieService();
    }

    public void addMovie(String name, Emotion emotion) {
        MovieDTO movieDTO = apiService.findMovieByTitle(name);

        if(movieDTO != null) {
            Movie movie = MovieMapper.toEntity(movieDTO, emotion);

            repository.save(movie);
            System.out.print("Película añadida con éxito!");
        } else {
            System.out.println("No se encontró la peli. Inténtalo de nuevo.");
        }

    }
}
