package dev.paula.movie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;

import dev.paula.movie.dtos.MovieDTO;
import dev.paula.movie.service.MovieService;

public class MovieServiceTest {
    
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        this.movieService = new MovieService();
    }

    @Test
    void testMappingResponseBody_ShouldReturnJsonObject() {
        String imdbId = "tt2250912";
        JsonObject json = movieService.getMovieInfo(imdbId);

        assertThat(json.get("imdbId").getAsString(), is(equalTo(imdbId)));
        assertThat(json.get("short").getAsJsonObject().get("name").getAsString(), is(equalTo("Spider-Man: Homecoming")));
        assertThat(json.get("short").getAsJsonObject().get("genre").getAsJsonArray().size(), is(equalTo(3)));
    }

    @Test
    void testMappingResponseBody_ShouldReturnAMovieDTO() {
        String imdbId = "tt2250912";
        MovieDTO movieInfo = movieService.getMovieInfoAndMapToDTO(imdbId);

        assertThat(movieInfo.getImdbId(), is(equalTo(imdbId)));
        assertThat(movieInfo.getShortInfo().getName(), is(equalTo("Spider-Man: Homecoming")));
        assertThat(movieInfo.getShortInfo().getGenre().length, is(equalTo(3)));
        assertThat(movieInfo.getShortInfo().getGenre()[0], is(equalTo("Action")));
    }

}
