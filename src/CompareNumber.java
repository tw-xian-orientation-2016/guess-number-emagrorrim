public class CompareNumber {

    public String compare(String answer, String input) {

        int A = 0, B = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (answer.charAt(i) == c) {
                A++;
            } else if (answer.indexOf(c) >= 0) {
                B++;
            }
        }

        return A + "A" + B + "B";
    }
}
