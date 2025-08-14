package dev.paula.view;


public class MomentFilterView extends View{

    public static void printFilterMenu(){
        String text = """
            Filtrar por ...:
            1. Emoción
            2. Fecha
            Ingrese una opción:
            """;
        System.out.print(text);
        int choice = SCANNER.nextInt();;

         if (choice == 1) MomentFilterEmotionView.filterByEmotion();
    }
    
}
