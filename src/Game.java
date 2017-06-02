import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private AnswerGenerator answerGenerator;
    private CompareNumber compareNumber;
    private BufferedReader bufferedReader;

    public Game(AnswerGenerator answerGenerator, CompareNumber compareNumber, BufferedReader bufferedReader) {
        this.answerGenerator = answerGenerator;
        this.compareNumber = compareNumber;
        this.bufferedReader = bufferedReader;
    }

    public void start() throws IOException {

        System.out.println("Welcome!\n");

        String answer = answerGenerator.generate();

        for (int i = 0; i < 6; i++) {
            System.out.println("Please input your number(" + (6 - i) + "): ");
            String input = bufferedReader.readLine();
            if (input.equals(answer)) {
                System.out.println("Congratulations!");
                break;
            }

            if (checkDuplicate(input)) {
                --i;
                System.out.println("Cannot input duplicate numbers!");
                continue;
            }

            System.out.println(compareNumber.compare(answer, input));
            if (i == 5) {
                System.out.println("Game Over");
            }
        }
    }

    public static boolean checkDuplicate(String number) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && number.charAt(i) == number.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
