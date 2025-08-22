package dev.paula.movie.view;

import java.util.Scanner;

import dev.paula.models.Emotion;
import dev.paula.movie.controller.MovieController;
import dev.paula.view.HomeView;
import dev.paula.view.View;

public class MoviePostView extends View{
    
    private static final MovieController movieController = new MovieController();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void addMovieFromApi() {
        System.out.println("--- Añadir una película desde la API de IMDb ---");
        System.out.print("Ingrese el ID de IMDb de la película (ej: tt0118583): ");
        String imdbId = SCANNER.nextLine();
        
        System.out.println("\n Elige la emoción");
        for (Emotion emotion :  Emotion.values()) {
            System.out.println(emotion.ordinal() + 1 + ". " + emotion.name());
        }
        System.out.print("Seleccione la emoción: ");
        int numberEmotion = SCANNER.nextInt();
        SCANNER.nextLine();
        Emotion emotion = Emotion.values()[numberEmotion - 1];


        movieController.addMovie(imdbId, emotion);
        HomeView.printMenu();

    }
}
