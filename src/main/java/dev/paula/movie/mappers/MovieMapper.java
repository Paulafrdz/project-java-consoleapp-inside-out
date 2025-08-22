package dev.paula.movie.mappers;

import java.time.LocalDate;

import dev.paula.models.Emotion;
import dev.paula.movie.dtos.MovieDTO;
import dev.paula.movie.models.Movie;

public class MovieMapper {
    
     public static Movie toEntity(MovieDTO dto, Emotion emotion) {

        String name = dto.getShortInfo().getName();
        String[] genresArray = dto.getShortInfo().getGenre();
        String datePublished = dto.getShortInfo().getDatePublished();
        String imdbId = dto.getImdbId();
        
        int id = 0;
        try {
            id = Integer.parseInt(imdbId);
        } catch (NumberFormatException e) {
            // Por si el ID no es un número
        }
        return new Movie(id, name, genresArray, emotion, datePublished, LocalDate.now().toString());
    }
}
