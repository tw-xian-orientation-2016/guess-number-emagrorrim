import java.util.Random;

public class AnswerGenerator {
    private Random random;

    public AnswerGenerator(Random random) {
        this.random = random;
    }

    public String generate() {

        String number = "";

        while (number.length() < 4) {
            String digit = String.valueOf(random.nextInt(10));

            if (!number.contains(digit)) {
                number += digit;
            }
        }

        return number;
    }
}
