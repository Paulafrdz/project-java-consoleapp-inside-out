package dev.paula.models;

import java.time.LocalDateTime;
import java.util.Date;


public class Moment {
    private static int nextId=1;

    private final int id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Date date;
    private String title;
    private String description;
    private Emotion emotion;

    public Moment(int id, String title, String description, Emotion emotion, Date date) {
        this.id = nextId;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.date = date;
        
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

    public Date getdate() {
        return date;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }


    //necesario??
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
               ", Fecha: " + date + ", Descripción: " + description;
    }
}