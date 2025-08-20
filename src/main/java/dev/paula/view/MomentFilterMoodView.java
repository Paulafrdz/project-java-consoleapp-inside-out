package dev.paula.view;

import java.util.List;

import dev.paula.controller.MomentController;
import dev.paula.dtos.MomentDTOResponse;
import dev.paula.models.Mood;
import dev.paula.singletons.MomentControllerSingleton;

public class MomentFilterMoodView extends View{

        private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void filterByMood() {

        System.out.println("Seleccione si el momento ha sido bueno o malo: ");
        Mood[] moods = Mood.values();

        for(Mood e : moods) {
            System.out.println((e.getnumberMood()) + "." + e.name());
        }
        
        int choice = SCANNER.nextInt();
        
        if(choice < 1 || choice > Mood.values().length) {
            System.out.println("Opción inválida.");
            HomeView.printMenu();
            return;
        }

        Mood selectedEmotion = Mood.values()[choice - 1];
        List<MomentDTOResponse> filtered = CONTROLLER.getMomentByMood(selectedEmotion);
        MomentGetView.printAllMoments(filtered);
        HomeView.printMenu();
    }
}
