package dev.paula.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {
    private final int id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDate dateOfMoment;
    private String title;
    private String description;
    private Emotion emotion;

    public Moment(int id, String title, String description, Emotion emotion, LocalDate dateOfMoment) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.dateOfMoment = dateOfMoment;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public Emotion getEmotion() {
        return emotion;
    }

    public LocalDate getDateOfMoment() {
        return dateOfMoment;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setTitle(String title) {
        this.title = title;
        this.modifiedAt = LocalDateTime.now();
    }

    public void setDescription(String description) {
        this.description = description;
        this.modifiedAt = LocalDateTime.now();
    }
    
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
        this.modifiedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + title + ", Emoción: " + emotion.getName() + 
               ", Fecha: " + dateOfMoment + ", Descripción: " + description;
    }
}