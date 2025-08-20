
package dev.paula.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

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
import org.mockito.MockedStatic;


class MomentGetViewTest {

     private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MockedStatic<HomeView> mockedHomeView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        // Mock the HomeView class to prevent its printMenu() method from executing.
        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testPrintAllMoments_WithData() {
        // Prepare test data
        List<MomentDTOResponse> moments = new ArrayList<>();
        moments.add(new MomentDTOResponse(
            1,
            "Playa",
            "un dia paseando por la playa",
            Emotion.ALEGRIA,
            new Date()
        ));

        // When HomeView.printMenu() is called, do nothing
        mockedHomeView.when(HomeView::printMenu).thenAnswer(invocation -> null);

        // Execute the method under test
        MomentGetView.printAllMoments(moments);

        // Verify the output
        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Lista de momentos vividos:"));
        assertThat(output, containsString("Playa"));

        // Verify that HomeView.printMenu() was called
        mockedHomeView.verify(HomeView::printMenu);
    }
    
    @Test
    void testPrintAllMoments_WithEmptyList() {
        // Prepare an empty list
        List<MomentDTOResponse> moments = new ArrayList<>();

        // When HomeView.printMenu() is called, do nothing
        mockedHomeView.when(HomeView::printMenu).thenAnswer(invocation -> null);
        // Execute the method under test
        MomentGetView.printAllMoments(moments);

        // Verify the output for an empty list
        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("No hay momentos guardados."));
        
        // Verify that HomeView.printMenu() was called
        mockedHomeView.verify(HomeView::printMenu, times(2));
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out
        System.setOut(originalOut);
        // Close the static mock
        mockedHomeView.close();
    }


}