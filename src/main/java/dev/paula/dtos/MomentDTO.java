package dev.paula.dtos;

import java.util.Date;

import dev.paula.models.Emotion;

public record MomentDTO(int id, String title, String description, Emotion emotion, Date date){
    
}
