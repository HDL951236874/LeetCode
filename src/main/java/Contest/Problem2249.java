package Contest;

import java.util.Map;

public class Problem2249 {
    public int countLatticePoints(int[][] circles) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int rd = circles[i][2];
            l = Math.min(x - rd, l);
            r = Math.max(r, x + rd);
            u = Math.max(u, y + rd);
            d = Math.min(d, y - rd);
        }
        for (int i = d; i <= u; i++) {
            for (int j = l; j <= r; j++) {
                for (int k = 0; k < circles.length; k++) {
                    double distance = Math.sqrt(Math.pow(circles[k][0] - j, 2) + Math.pow(circles[k][1] - i, 2));
                    if (distance <= (double) circles[k][2]) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem2249 problem2249 = new Problem2249();
        System.out.println(problem2249.countLatticePoints(new int[][]{{2, 2, 2}, {3, 4, 1}}));
    }
}
