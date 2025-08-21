package dev.paula.movie.singleton;

import dev.paula.movie.repository.MovieCSVRepository; ;

public class MovieRepositorySingleton {
    
    private static MovieCSVRepository INSTANCE;

    private MovieRepositorySingleton() {}

    public static MovieCSVRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieCSVRepository();
        }
        return INSTANCE;
    }
}
