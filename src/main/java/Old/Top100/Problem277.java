package Top100;

import java.util.Arrays;

public class Problem277 {
    public int findCelebrity(int n) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) temp[i][j] = 1;
                else temp[i][j] = 0;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (Arrays.stream(temp[i]).sum() == 1) {
                boolean celebrity = true;
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j][i] != 1) {
                        celebrity = false;
                        break;
                    }
                }
                if (celebrity) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean knows(int i, int j) {
        return true;
    }


}
