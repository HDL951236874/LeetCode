package Jianzhi;

import java.util.HashMap;
import java.util.Map;

public class jianzhi7 {
    Map<Integer, Integer> map = new HashMap<>();

    public int numWays(int n) {
        if (map.containsKey(n)) return map.get(n);

        if (n == 0) return 1;
        if (n == 1) return 1;
        int res = (numWays(n - 1) + numWays(n - 2))%1000000007;
        map.put(n, res);
        return res;
    }
}
