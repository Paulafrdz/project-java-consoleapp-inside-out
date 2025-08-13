package dev.paula.view;

import dev.paula.controller.MomentController;
import dev.paula.singletons.MomentControllerSingleton;


public class MomentDeleteView extends View{
    
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printDeleteMenu(){
        System.out.println("Ingresa el identificador del momento: ");
        int id = SCANNER.nextInt();
        CONTROLLER.deleteMoment(id);

        HomeView.printMenu();
    }
    

}
