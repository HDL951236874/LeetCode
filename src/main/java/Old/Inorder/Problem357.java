package Inorder;

public class Problem357 {
    //relationship is very important
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)return 1;
        if(n == 1) return 10;
        int a = countNumbersWithUniqueDigits(n-1);
        int b = countNumbersWithUniqueDigits(n-2);
        return a + (a-b)*(11-n);
    }
}
