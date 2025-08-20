package dev.paula.controller;

import java.util.ArrayList;
import java.util.List;

import dev.paula.dtos.MomentDTO;
import dev.paula.mappers.MomentMapper;
import dev.paula.models.Moment;
import dev.paula.repository.MomentRepository;
import dev.paula.singletons.MomentRepositorySingleton;
import dev.paula.dtos.MomentDTOResponse;
import dev.paula.view.MomentGetView;
import dev.paula.models.Emotion;
import dev.paula.models.Mood;

public class MomentController {
    
    private MomentRepository repository;

    public MomentController(){
        this.repository = MomentRepositorySingleton.getInstance();
    }

    
    public void StoreMoment(MomentDTO momentDTO){
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }

    public void getAllMoments(){
        List<MomentDTOResponse> MomentsDTO = new ArrayList<>();
        List<Moment> moments = repository.getAllMoments();

        for (Moment moment : moments) {
            MomentsDTO.add(new MomentDTOResponse(moment.getId(), moment.getTitle(), moment.getDescription(), moment.getEmotion(), moment.getDate(), moment.getMood()));
        }
        MomentGetView.printAllMoments(MomentsDTO);

    }

    public void deleteMoment(int id){
        repository.deleteMoment(id);
        System.out.println("Momento vivído eliminado correctamente.");
    }

    public List<MomentDTOResponse> getMomentByEmotion(Emotion emotion){
        List<MomentDTOResponse> out = new ArrayList<>();
        for (Moment m : repository.findByEmotions(emotion)) {
            out.add(MomentMapper.toResponse(m));
        }
        return out;
    }

    public List<MomentDTOResponse> getMomentsByDate(int month){
        List<MomentDTOResponse> out = new ArrayList<>();
        for (Moment m : repository.getMomentsByDate(month)) {
            out.add(MomentMapper.toResponse(m));
        }
        return out;
    }

    public List<MomentDTOResponse> getMomentByMood(Mood mood){
        List<MomentDTOResponse> out = new ArrayList<>();
        for (Moment m : repository.findByMood(mood)) {
            out.add(MomentMapper.toResponse(m));
        }
        return out;
    }
}

