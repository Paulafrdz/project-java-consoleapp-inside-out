package dev.paula.view;


public class MomentFilterView extends View{

    public static void printFilterMenu(){
        String text = """
            Filtrar por ...:
            1. Emoción
            2. Fecha
            3. Momento
            Ingrese una opción:
            """;
        System.out.print(text);
        int choice = SCANNER.nextInt();;

         if (choice == 1) MomentFilterEmotionView.filterByEmotion();
         if (choice == 2) MomentFilterDateView.filterByDate();
         if (choice == 3) MomentFilterMoodView.filterByMood();

    }
    
}
