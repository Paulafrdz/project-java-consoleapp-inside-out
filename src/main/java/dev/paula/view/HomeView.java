package dev.paula.view;

import java.util.Scanner;

import dev.paula.controller.MomentController;
import dev.paula.movie.view.MoviePostView;
import dev.paula.singletons.MomentControllerSingleton;

public class HomeView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printMenu() {

        String text = """
                My diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Exportar a CSV
                6. Añadir pelicula 
                7. Salir
                ------------------
                Seleccione una opción:
                """;

        System.out.print(text);

        int option = SCANNER.nextInt();


        if (option == 1) MomentPostView.printStoreMenu();
        if (option == 2) CONTROLLER.getAllMoments();
        if (option == 3) MomentDeleteView.printDeleteMenu();
        if (option == 4) MomentFilterView.printFilterMenu();
        if (option == 5) MomentExportCSVView.printExportMenu();
        if (option == 6) MoviePostView.addMovieFromApi();
        if (option == 7); System.out.println("¡Hasta la próxima! 👋");

    }
    public static Scanner getSCANNER() {
        return SCANNER;
    }
    
}
