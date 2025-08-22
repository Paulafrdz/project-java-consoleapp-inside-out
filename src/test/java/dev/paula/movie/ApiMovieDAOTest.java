package dev.paula.movie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.paula.movie.daos.ApiMovieDAO;
import dev.paula.movie.daos.InterfaceApiMoviesDAO;

public class ApiMovieDAOTest {
    
    private InterfaceApiMoviesDAO caller;

    @BeforeEach
    void setUp(){
        this.caller = new ApiMovieDAO();
    }

    @Test
    void testGetCall() {
        String imdbId = "tt2250912";
        String body = caller.getMovie(imdbId);
        assertThat(body, not(nullValue()));
        assertThat(body, containsString("error_code"));
        assertThat(body, containsString("Spider-Man: Homecoming"));
    }

    @Test
    void testGetCall_ShouldReturnAnExceptionIfMovieDoesNotExist() {
        String body = caller.getMovie("");
        assertThat(body, containsString("pass 'q' OR 'tt' as a query string parameter"));
    }

}
