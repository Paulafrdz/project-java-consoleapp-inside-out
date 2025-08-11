package dev.paula.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {
    private final int id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate dateOfMoment;

    public Moment(int id, String title, String description, Emotion emotion, LocalDate dateOfMoment) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.dateOfMoment = dateOfMoment;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = this.createdAt;
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
}