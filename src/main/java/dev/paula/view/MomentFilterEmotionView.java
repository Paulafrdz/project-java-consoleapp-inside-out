package dev.paula.view;

import java.util.List;

import dev.paula.controller.MomentController;
import dev.paula.dtos.MomentDTOResponse;
import dev.paula.models.Emotion;
import dev.paula.singletons.MomentControllerSingleton;

public class MomentFilterEmotionView extends View{
    
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void filterByEmotion(){
        System.out.println("Seleccione una opción: ");
        Emotion[] emotions = Emotion.values();

        for(Emotion e : emotions) {
            System.out.println((e.getnumberEmotion()) + "." + e.name());
        }
        
        int choice = SCANNER.nextInt();
        
        if(choice < 1 || choice > Emotion.values().length) {
            System.out.println("Opción inválida.");
            HomeView.printMenu();
            return;
        }

        Emotion selectedEmotion = Emotion.values()[choice - 1];
        List<MomentDTOResponse> filtered = CONTROLLER.getMomentByEmotion(selectedEmotion);
        MomentGetView.printAllMoments(filtered);
        HomeView.printMenu();



    }
}
