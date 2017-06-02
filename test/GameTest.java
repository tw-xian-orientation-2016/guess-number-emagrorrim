import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import static org.mockito.Mockito.*;


public class GameTest {
    @Test
    public void start_game_then_print_congratulations() throws IOException {

        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1234");
        Game game = new Game(new AnswerGenerator(random), new CompareNumber(), bufferedReader);

        PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        game.start();

        verify(mockPrintStream).println("Welcome!\n");
        verify(mockPrintStream).println("Please input your number(6): ");
        verify(mockPrintStream).println("Congratulations!");

    }

    @Test
    public void start_game_then_print_game_over() throws IOException {

        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5678", "9043", "1243", "2345", "9871", "2354");
        Game game = new Game(new AnswerGenerator(random), new CompareNumber(), bufferedReader);

        PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        game.start();

        verify(mockPrintStream).println("Welcome!\n");
        verify(mockPrintStream).println("Please input your number(6): ");
        verify(mockPrintStream).println("0A0B");
        verify(mockPrintStream).println("Please input your number(5): ");
        verify(mockPrintStream).println("0A2B");
        verify(mockPrintStream).println("Please input your number(4): ");
        verify(mockPrintStream).println("2A2B");
        verify(mockPrintStream).println("Please input your number(3): ");
        verify(mockPrintStream).println("0A3B");
        verify(mockPrintStream).println("Please input your number(2): ");
        verify(mockPrintStream).println("0A1B");
        verify(mockPrintStream).println("Please input your number(1): ");
        verify(mockPrintStream).println("1A2B");
        verify(mockPrintStream).println("Game Over");
    }

    @Test
    public void start_game_then_print_repeat_error_information() throws IOException {

        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5678", "9043", "1242", "1243", "2345", "9871", "2354");
        Game game = new Game(new AnswerGenerator(random), new CompareNumber(), bufferedReader);

        PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        game.start();

        verify(mockPrintStream).println("Please input your number(6): ");
        verify(mockPrintStream).println("0A0B");
        verify(mockPrintStream).println("Please input your number(5): ");
        verify(mockPrintStream).println("0A2B");
        verify(mockPrintStream, times(2)).println("Please input your number(4): ");
        verify(mockPrintStream).println("Cannot input duplicate numbers!");
        verify(mockPrintStream).println("2A2B");
        verify(mockPrintStream).println("Please input your number(3): ");
        verify(mockPrintStream).println("0A3B");
        verify(mockPrintStream).println("Please input your number(2): ");
        verify(mockPrintStream).println("0A1B");
        verify(mockPrintStream).println("Please input your number(1): ");
        verify(mockPrintStream).println("1A2B");
        verify(mockPrintStream).println("Game Over");
    }

}
