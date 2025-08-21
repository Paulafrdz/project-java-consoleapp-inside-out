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

    public MovieService(ApiMovieDAO movieDAO) {
        this.movieDAO = movieDAO;
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
}
