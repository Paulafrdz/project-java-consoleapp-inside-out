package dev.paula.models;

public enum Mood {
    
    BUENA(1),
    MALA(2);

    private int numberMood;
    public int getnumberMood() {
        return numberMood;
    }

    Mood(int numberMood) {
        this.numberMood = numberMood;
    }
}
