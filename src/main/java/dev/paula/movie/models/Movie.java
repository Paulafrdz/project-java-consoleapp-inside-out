package dev.paula.movie.models;

import dev.paula.models.Emotion;

public class Movie {
    
    private int imdbId;
    private String name;
    private String[] genre;
    private Emotion emotion;
    private String releaseYear;
    private String creationDate;

    public Movie(int imdbId, String name, String[] genre, Emotion emotion, String releaseYear, String creationDate) {
        this.imdbId = imdbId;
        this.name = name;
        this.genre = genre;
        this.emotion = emotion;
        this.releaseYear = releaseYear;
        this.creationDate = creationDate;
    }

    public String toCSVString() {
        // Handle the genre array by joining the elements with a comma
        // The regex `\\s*,\\s*` handles commas with surrounding whitespace
        String genreString = String.join(",", this.genre); 

        return String.format("%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
            this.imdbId,
            this.name,
            genreString,
            this.emotion.name(), // Assuming Emotion is an enum, use .name() to get its string representation
            this.releaseYear,
            this.creationDate
        );
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

    public String[] getGenre() { 
        return genre; 
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
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

    public String getCreationDate() { 
        return creationDate; 
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
