package dev.paula.models;

public enum Emotion {
    ALEGRIA("Alegría"),
    TRISTEZA("Tristeza"),
    IRA("Ira"),
    ASCO("Asco"),
    MIEDO("Miedo"),
    ANSIEDAD("Ansiedad"),
    ENVIDIA("Envidia"),
    VERGUENZA("Vergüenza"),
    ABURRIMIENTO("Aburrimiento"),
    NOSTALGIA("Nostalgia");

    String name;

    Emotion(String string) {
        name = string;
    }
    public String getName() {
        return name;
    }
}


