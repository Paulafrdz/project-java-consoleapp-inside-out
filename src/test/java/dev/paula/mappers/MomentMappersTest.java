package dev.paula.mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dev.paula.dtos.MomentDTO;
import dev.paula.models.Emotion;
import dev.paula.models.Moment;
import dev.paula.models.Mood;

public class MomentMappersTest {
    
    void testCharacterDTOToCharacterEntity() {
        Emotion emotion = Emotion.ALEGRIA;
        Mood mood = Mood.BUENO;

        
        MomentDTO dto = new MomentDTO(
            1,
            "playa",
            "un dia paseando en la playa",
            emotion,
            date,
            mood
        );

        // When
        Moment moment = MomentMapper.toEntity(dto);

        // Then
        assertThat(moment.getEmotion(), is(equalTo(dto.emotion())));
        assertThat(moment.getDescription(), is(equalTo(dto.description())));
    }
}
