import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {
    @Test
    public void start_game_then_print_congratulations() throws IOException {
        Game game = new Game();
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1234");

        PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);
        game.start();



        verify(mockPrintStream).println("Congratulations!");

    }

//    @Test
//    public void start_game_then_print_game_over() {
//
//    }

}
