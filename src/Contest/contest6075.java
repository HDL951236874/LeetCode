package Contest;

import javafx.util.Pair;

import java.util.*;

public class contest6075 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rocks.length; i++) {
            list.add(capacity[i] - rocks[i]);
        }
        Collections.sort(list);
        int p = 0;
        int res = 0;
        while (additionalRocks > 0 && p < list.size()) {
            if (list.get(p) > 0) {
                additionalRocks -= list.get(p);
            }
            if (additionalRocks >= 0)
                res++;
            p++;
        }
        return res;
    }

}
