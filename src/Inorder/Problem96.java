package Inorder;

public class Problem96 {
    public int numTrees(int n) {

        int sum = 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 0; i <= n-1; i++) {
            sum += Math.max(1, numTrees(i)) * Math.max(1, numTrees(n - 1 - i));
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem96 p = new Problem96();
        System.out.println(p.numTrees(3));
    }
}
