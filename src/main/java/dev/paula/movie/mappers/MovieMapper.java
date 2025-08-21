package dev.paula.movie.mappers;

import java.time.LocalDate;

import dev.paula.movie.dtos.MovieDTO;
import dev.paula.movie.models.Movie;

public class MovieMapper {
    
     public static Movie toEntity(MovieDTO dto) {

        String name = dto.getShortInfo().getName();
        String[] genresArray = dto.getShortInfo().getGenre();
        String releaseYear = dto.getShortInfo().getReleaseYear();
        String imdbId = dto.getImdbId();
        
        int id = 0;
        try {
            id = Integer.parseInt(imdbId);
        } catch (NumberFormatException e) {
            // Por si el ID no es un número
        }
        return new Movie(id, name, genresArray, null, releaseYear, LocalDate.now().toString());
    }
}
