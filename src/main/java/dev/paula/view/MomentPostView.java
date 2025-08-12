package dev.paula.view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MomentPostView extends View{

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.nextLine();


        Date inputDate = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputFormat.setLenient(false); // para evitar que acepte fechas inválidas
        while (inputDate == null) {
            System.out.println("Ingresa la fecha (dd/MM/yyyy):");
            String dateStr = SCANNER.nextLine();
        try {
            inputDate = inputFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Intente de nuevo.");
        }
    };

    
    }
}