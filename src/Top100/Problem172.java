package Top100;

public class Problem172 {
    public int trailingZeroes_(int n) {
        int index = 1;
        int sum = 1;
        int c = 0;
        while (index <= n) {
            sum *= index;
            while (sum % 10 == 0) {
                c++;
                sum = sum / 10;
            }
            sum = sum % 10;
            index++;
        }
        return c;
    }



    public static void main(String[] args) {
        Problem172 p = new Problem172();
        System.out.println(p.trailingZeroes_(625));
    }
}
