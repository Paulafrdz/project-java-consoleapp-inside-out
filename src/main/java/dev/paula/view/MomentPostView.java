package dev.paula.view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import dev.paula.dtos.MomentDTO;
import dev.paula.models.Emotion;
import dev.paula.controller.MomentController;
import dev.paula.singletons.MomentControllerSingleton;

public class MomentPostView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String title = SCANNER.nextLine();


        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputFormat.setLenient(false); // para evitar que acepte fechas inválidas
        while (date == null) {
            System.out.println("Ingresa la fecha (dd/MM/yyyy):");
            String dateStr = SCANNER.nextLine();
        try {
            date = inputFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Intente de nuevo.");
        }
        };
        

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.nextLine();

        String text = """
                Selecciona una emoción:
                1. Alegría
                2. Tristeza
                3. Ira
                4. Asco
                5. Miedo
                6. Ansiedad
                7. Envidia
                8. Vergüenza
                9. Aburrimiento
                10. Nostalgia
                """;

        System.out.print(text);
        
        int numberEmotion = SCANNER.nextInt();
        SCANNER.nextLine(); // consume newline left-over

        Emotion emotion = Emotion.values()[numberEmotion - 1];

        MomentDTO moment = new MomentDTO(0, title, description, emotion, date);
        CONTROLLER.StoreMoment(moment);

        System.out.println("Momento vivído añadido correctamente.");

        HomeView.printMenu();
    }
    
    
}
