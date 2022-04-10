package Top100;

import java.net.Inet4Address;

public class Problem29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == 0) return 0;
        int t = dividend;
        int j = divisor;
        if (dividend > 0) {
            t = -dividend;
        } ;
        if (divisor > 0) {
            j = -divisor;
        } ;
        int num = 0;
        while (t - j <= 0) {
            t -= j;
            num++;
        }

        if (dividend > 0 && divisor > 0) return num;
        if (dividend < 0 && divisor < 0) return num;
        if (dividend > 0 && divisor < 0) return -num;
        if (dividend < 0 && divisor > 0) return -num;
        return 0;
    }

    public static void main(String[] args) {
        Problem29 p = new Problem29();
        p.divide(
                2147483647, 2);
    }
}
