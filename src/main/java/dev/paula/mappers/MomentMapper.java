package dev.paula.mappers;

import dev.paula.dtos.MomentDTO;
import dev.paula.dtos.MomentDTOResponse;
import dev.paula.models.Moment;

public class MomentMapper {

    public static Moment toEntity(MomentDTO dto) {
        
        Moment moment = new Moment(dto.id(), dto.title(),dto.description(),dto.emotion(),dto.date());
        return moment;
    }
    public static MomentDTOResponse toResponse(Moment m){
        return new MomentDTOResponse(m.getId(), m.getTitle(), m.getDescription(), m.getEmotion(), m.getDate());
    }
}
