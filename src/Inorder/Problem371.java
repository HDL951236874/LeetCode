package Inorder;

public class Problem371 {
    public int getSum(int a, int b) {
        for (int i = 0; i < Math.abs(b); i++) {
            if(b>0) a++;
            if(b<0) a--;
        }
        return a;
    }
}
