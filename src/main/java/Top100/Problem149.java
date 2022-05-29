package Top100;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Problem149 {
    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;
        Set<Pair<Integer, Integer>> have_check = new HashSet<>();
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (have_check.contains(new Pair<>(i, j))) continue;
                int max_ = 2;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int A = y2 - y1;
                int B = x1 - x2;
                int C = x2 * y1 - x1 * y2;
                for (int k = j + 1; k < points.length; k++) {
                    if (have_check.contains(new Pair<>(j, k))) continue;
                    if (points[k][0] * A + points[k][1] * B + C == 0) {
                        max_++;
                        have_check.add(new Pair<>(j, k));
                        have_check.add(new Pair<>(i, k));
                    }
                }
                max = Math.max(max_,max);
            }
        }
        return max;
    }
}
