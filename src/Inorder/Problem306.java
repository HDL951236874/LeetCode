package Inorder;

public class Problem306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3 || num.charAt(0) == '0') return false;
        else {
            for (int i = 2; i < num.length(); i++) {
                if (Integer.valueOf(String.valueOf(num.charAt(i))) != (Integer.valueOf(String.valueOf(num.charAt(i - 1))) + Integer.valueOf(String.valueOf(num.charAt(i - 2))) % 10))
                    return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem306 problem306 = new Problem306();
        System.out.println(problem306.isAdditiveNumber("112358"));
    }
}
