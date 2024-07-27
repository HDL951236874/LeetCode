package Inorder;

public class Problem372 {
    public int superPow(int a, int[] b) {
        int num = 0;
        int res = 1;
        for (int i = b.length; i >= 0; i--) {
            res *= (int) (b[i] * Math.pow(10, num));
            num++;
            res %= 1337;
        }
        return res;
    }
}
