package dev.paula.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MomentFilterViewTest {
    
    private final InputStream inputPInputStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private MockedStatic<MomentFilterEmotionView> mockedPostView;

    @BeforeEach
    void setUp(){
        mockedPostView = mockStatic(MomentFilterEmotionView.class);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void givenOption1_whenPrintFilterMenu_thenCallsFilterByEmotion() {
        // arrange
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new Scanner(System.in);

        // act
        MomentFilterView.printFilterMenu();

        // assert (verifica salida)
        String output = outputStreamCaptor.toString().replace("\r", "");
        assertThat(output, containsString("Ingrese una opción:"));

        // assert (verifica que se llamó al método mockeado)
        mockedPostView.verify(() -> MomentFilterEmotionView.filterByEmotion(), times(1));
    }

    

    @Test
    void testPrintMenu_SelectOption1_Mocking(){
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        View.SCANNER = new Scanner(System.in);
        MomentFilterView.printFilterMenu();

        String output = outputStreamCaptor.toString().replace("\r", "");
        assertThat(output, containsString("Ingrese una opción:"));
 
    }

    @Test
    void givenStaticMockRegistration_whenMocked_thenReturnsMockSuccessfully(){
        assertTrue(Mockito.mockingDetails(MomentFilterEmotionView.class).isMock());
    }

    @Test
    public void givenAnotherStaticMockRegistration_whenMocked_thenReturnsMockSuccessfully(){
        assertTrue(Mockito.mockingDetails(MomentFilterEmotionView.class).isMock());
    }

    @AfterEach
    void tearDown(){
        System.setIn(inputPInputStream);
        System.setOut(printStream);
        mockedPostView.close();
    }
}

