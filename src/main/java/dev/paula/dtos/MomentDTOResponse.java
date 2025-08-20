package dev.paula.dtos;

import java.util.Date;

import dev.paula.models.Emotion;
import dev.paula.models.Mood;

public record MomentDTOResponse(int id, String title, String description, Emotion emotion, Date date, Mood mood) {
    
}
