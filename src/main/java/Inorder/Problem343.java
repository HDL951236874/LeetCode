package Inorder;

public class Problem343 {

    public int integerBreak(int n) {
        if(n<=3){
            if(n == 3) return 2;
            if(n ==2) return 1;
        }
        int res = 0;
        if (n % 3 == 0) {
            res =  (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            res =  (int) Math.pow(3, n / 3 - 1) * 4;
        } else if (n % 3 == 2) {
            res =  (int) Math.pow(3, n / 3) * 2;
        }
        return res;
    }
}
