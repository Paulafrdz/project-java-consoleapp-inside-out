package dev.paula.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mockStatic;

class MomentDeleteViewTest {

    private final PrintStream standardOut = System.out;
    private final java.io.InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void testPrintDeleteMenuDeletesMoment() {
        String simulatedUserInput = "3\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        View.SCANNER = new java.util.Scanner(System.in);

        try (MockedStatic<HomeView> mockedHomeView = mockStatic(HomeView.class)) {
            MomentDeleteView.printDeleteMenu();
             mockedHomeView.verify(() -> HomeView.printMenu());
        }
        
        String output = outputStreamCaptor.toString().trim();
        assertThat(output, containsString("Ingresa el identificador del momento"));
        assertThat(output, containsString("Momento vivído eliminado correctamente."));
    }
}

