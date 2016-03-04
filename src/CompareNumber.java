public class CompareNumber {

    public String compare(String num1, String num2) {
        Integer countA = getCountA(num1, num2);
        Integer countB = getCountB(num1, num2);
        return countA + "A" + countB + "B";
    }

    private Integer getCountA(String num1, String num2) {
        return 0;
    }

    private Integer getCountB(String num1, String num2) {
        return 0;
    }
}
