package dev.paula.movie.models;


import java.util.List;

import dev.paula.models.Emotion;

public class Movie {
    
    private int imdbId;
    private String name;
    private List<String> genres;
    private Emotion emotion;
    private String releaseYear;
    private String createdAt;

    public Movie(int imdbId, String name, List<String> genres, Emotion emotion, String releaseYear, String createdAt) {
        this.imdbId = imdbId;
        this.name = name;
        this.genres = genres;
        this.emotion = emotion;
        this.releaseYear = releaseYear;
        this.createdAt = createdAt;
    }

    public int getImdbId() {
        return imdbId;
    }

    public void setImdbId(int imdbId) {
        this.imdbId = imdbId;
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() { 
        return genres; 
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Emotion getEmotion() { 
        return emotion; 
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public String getReleaseYear() { 
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCreatedAt() { 
        return createdAt; 
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
