package Top100;

import java.util.Map;

public class Problem50 {
    public double myPow_(double x, int n) {
        // this method is too slow
        double ini = x;
        int num = Math.abs(n);
        while (num > 1) {
            x = x * ini;
            num--;
        }
        if (n < 0) {
            return 1 / x;
        } else if (n > 0) {
            return x;
        } else return 1;
    }

    public double myPow(double x, int n) {
        //when it comes to do the this for multi times, we can use iteration
        if (n == 0) return 1;
        else if (n == 1) return x;
        else if (n == -1) return 1 / x;
        double num = myPow(x,n/2);
        if (n % 2 == 0) {
            return num*num;
        } else if (n % 2 != 0) {
            if (n < 0) {
                return num*num* 1/x;
            }else {
                return num*num* x;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem50 p = new Problem50();
        System.out.println(p.myPow(34.00515, -3));
    }
}
