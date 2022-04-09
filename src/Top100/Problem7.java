package Top100;

import java.net.Inet4Address;

public class Problem7 {
    // this is a good question
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if(res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem7 p = new Problem7();
        p.reverse(123);
    }
}
