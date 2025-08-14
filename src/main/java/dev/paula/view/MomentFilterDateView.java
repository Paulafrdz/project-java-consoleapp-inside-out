package dev.paula.view;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import dev.paula.controller.MomentController;
import dev.paula.dtos.MomentDTOResponse;
import dev.paula.singletons.MomentControllerSingleton;

public class MomentFilterDateView extends View {
    
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void filterByDate(){
        Scanner scanner = SCANNER;
        System.out.print("Ingrese la fecha (dd/mm/year): ");
        String dateString = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Use dd/MM/yyyy.");
            HomeView.printMenu();
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;

        List<MomentDTOResponse> moments = CONTROLLER.getMomentsByDate(month);

        if (moments.isEmpty()) {
            System.out.println("No hay momentos vividos en ese mes.");
        } else {
            MomentGetView.printAllMoments(moments);
        }

        HomeView.printMenu();
    }

}
