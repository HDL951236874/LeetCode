package Contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class contest2250 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] res = new int[points.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                if (rectangles[j][0] >= points[i][0] && rectangles[j][1] >= points[i][1]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
