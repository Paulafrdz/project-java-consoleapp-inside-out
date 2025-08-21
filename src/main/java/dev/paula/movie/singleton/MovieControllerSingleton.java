package dev.paula.movie.singleton;

import dev.paula.movie.controller.MovieController;

public class MovieControllerSingleton {
    
    private static final MovieController INSTANCE = new MovieController();

    private MovieControllerSingleton() {}
    
    public static MovieController getInstance() {
        return INSTANCE;
    }
}
