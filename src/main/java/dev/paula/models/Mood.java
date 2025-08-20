package dev.paula.models;

public enum Mood {
    
    BUENO(1),
    MALO(2);

    private int numberMood;
    public int getnumberMood() {
        return numberMood;
    }

    Mood(int numberMood) {
        this.numberMood = numberMood;
    }
}
