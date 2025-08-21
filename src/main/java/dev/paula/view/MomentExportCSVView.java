package dev.paula.view;

import dev.paula.controller.MomentController;
import dev.paula.singletons.MomentControllerSingleton;

public class MomentExportCSVView extends View{

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printExportMenu(){
        String exporText = """
            Exportar a CSV:
            Ingresa el nombre para el archivo CSV: 
            """;

        System.out.println(exporText);
        SCANNER.nextLine();

        String fileName = SCANNER.nextLine();

        if (fileName.isEmpty()) {
            fileName = "diario.csv";
        }

        CONTROLLER.exportAllMoments(fileName);
        System.out.println("Momento exportado correctamente.");

        HomeView.printMenu();

    }

    
}
