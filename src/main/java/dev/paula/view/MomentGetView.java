package dev.paula.view;

import java.util.List;

import dev.paula.dtos.MomentDTOResponse;

public class MomentGetView extends View{
    
    public static void printAllMoments(List<MomentDTOResponse> moments){
         if (moments.isEmpty()) {
            System.out.println("No hay momentos guardados.");
            HomeView.printMenu();
        }

        System.out.print("Lista de momentos vividos: \n");
        for (MomentDTOResponse moment : moments){
            System.out.println(moment.id() + " Ocurrio el: " + moment.date() + " Título: " + moment.title() + " Descripción: " + moment.description() + " Emoción: " + moment.emotion());
        }
       
        HomeView.printMenu();
    }

}
