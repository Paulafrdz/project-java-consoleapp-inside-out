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
            MomentsDTO.add(new MomentDTOResponse(moment.getId(), moment.getTitle(), moment.getDescription(), moment.getEmotion(), moment.getdate()));
        }
        MomentGetView.printAllMoments(MomentsDTO);

    }

    public void deleteMoment(int id){
        repository.deleteMoment(id);
        System.out.println("Momento vivído eliminado correctamente.");
    }
}
