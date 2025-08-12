package dev.paula.controller;

import dev.paula.dtos.MomentDTO;
import dev.paula.mappers.CharacterMapper;
import dev.paula.models.Moment;
import dev.paula.repository.MomentRepository;
import dev.paula.singletons.MomentRepositorySingleton;


public class MomentController {
    
    private MomentRepository repository;

    public MomentController(){
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void StoreMoment(MomentDTO momentDTO){
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }
}
