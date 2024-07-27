package Inorder;

public class Problem276 {
    public int numWays(int n, int k) {
        if (k == 1) {
            if (n > 2) return 0;
            else return 1;
        }
        if (n == 1) return k;
        if (n == 2) return k + k * (k - 1);
        int same = k;
        int diff = k * (k - 1);
        for (int i = 3; i <= n; i++) {
            int temp_diff = same * (k - 1) + diff * (k - 1);
            int temp_same = diff;
            diff = temp_diff;
            same = temp_same;
        }
        return same + diff;
    }
}
