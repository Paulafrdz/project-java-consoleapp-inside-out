package dev.paula.view;

import java.util.List;

import dev.paula.dtos.MomentDTOResponse;

public class MomentGetView extends View{
    
    public static void printAllMoments(List<MomentDTOResponse> moments){
        System.out.print("Lista de momentos vividos: ");
        for (MomentDTOResponse moment : moments){
            System.out.println("Ocurrio el: " + moment.date() + " Título: " + moment.title() + " Descripción: " + moment.description() + " Emoción: " + moment.emotion());
        }
        HomeView.printMenu();
    }

}
