package dev.paula.movie.service;

import java.io.StringReader;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

import dev.paula.movie.dtos.MovieDTO;
import dev.paula.movie.daos.ApiMovieDAO;

public class MovieService {
    
    private ApiMovieDAO movieDAO;
    private final Gson gson;


    public MovieService() {
        this.movieDAO = new ApiMovieDAO();
        this.gson = new GsonBuilder().create();
    }

    public JsonObject getMovieInfo (String imdbId) {
        String movieData = movieDAO.getMovie(imdbId);

        StringReader reader = new StringReader(movieData);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

        return jsonObject;
    }

    public MovieDTO getMovieInfoAndMapToDTO(String imdbId) {
        Gson gson = new GsonBuilder().create();
        String movieData = movieDAO.getMovie(imdbId);

        MovieDTO movieDTO = gson.fromJson(movieData, MovieDTO.class);

        return movieDTO;
    }

    public MovieDTO findMovieByTitle(String title) {
        String movieData = movieDAO.getMovie(title);

        if (movieData == null) {
            return null;
        }

        MovieDTO movieDTO = gson.fromJson(movieData, MovieDTO.class);

        // Check for an API error response
        if (movieDTO != null && "False".equalsIgnoreCase(movieDTO.getResponse())) {
            System.err.println("Error from API: " + movieDTO.getError());
            return null;
        }
        
        return movieDTO;
    }
}
