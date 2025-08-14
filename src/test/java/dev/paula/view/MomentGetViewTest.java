
package dev.paula.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import dev.paula.dtos.MomentDTOResponse;
import dev.paula.models.Emotion;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MomentGetViewTest {

    private final PrintStream PrintStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        View.TEST_MODE = true;
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    

    @Test
    void testPrintAllMoments(){

        
        String expected = "Lista de momentos vividos: ";
        List<MomentDTOResponse> moments = new ArrayList<>();
        moments.add(new MomentDTOResponse(
        1,
        "Playa",
        "un dia paseando por la playa",
        Emotion.ALEGRIA, // Usa el enum correspondiente
        new Date()       // Usa la fecha que quieras
        ));

        MomentGetView.printAllMoments(moments);

        assertThat(outputStreamCaptor.toString().trim(), containsString(expected));
        assertThat(outputStreamCaptor.toString().trim(), containsString("Playa"));

    } 

   @AfterEach
    void tearDown() {
        System.setOut(PrintStream);
    }


}