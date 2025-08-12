package dev.paula.dtos;

import java.time.LocalDate;

import dev.paula.models.Emotion;

public record MomentDTO(int id, String title, String description, Emotion emotion, LocalDate dateOfMoment){
    
}
