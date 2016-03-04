public class CompareNumber {

    public String compare(String num1, String num2) {

        int A = 0, B = 0;

        for (int i = 0; i < num2.length(); i++) {
            char c = num2.charAt(i);
            if (num1.charAt(i) == c) {
                A++;
            } else if (num1.indexOf(c) >= 0) {
                B++;
            }
        }

        return A + "A" + B + "B";
    }
}
