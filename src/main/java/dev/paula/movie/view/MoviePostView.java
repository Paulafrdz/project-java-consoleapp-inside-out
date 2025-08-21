package dev.paula.movie.view;

import java.util.Scanner;

import dev.paula.models.Emotion;
import dev.paula.movie.controller.MovieController;
import dev.paula.view.HomeView;

public class MoviePostView {
    
    private static final MovieController movieController = new MovieController();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void addMovieFromApi() {
        System.out.println("--- Añadir una película desde la API de IMDb ---");
        System.out.print("Ingrese el ID de IMDb de la película (ej: tt0118583): ");
        String imdbId = SCANNER.nextLine();
        
        System.out.print("Ingrese la emoción que le provocó (ALEGRIA, TRISTEZA, etc.): ");
        Emotion emotion = Emotion.valueOf(SCANNER.next().toUpperCase());

        System.out.print("Ingrese la fecha:  ");
        String createDate = SCANNER.nextLine();

        movieController.addMovie(imdbId, emotion, createDate);
        HomeView.printMenu();

    }
}
