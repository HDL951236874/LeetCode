package Top100;

import java.util.HashMap;
import java.util.Map;

public class Problem70 {
    //this is the first way, you need to reduce the doing of the calculation
    public int climbStairs_(int n) {
        return climb(n, new HashMap<>());
    }

    public int climb(int n, Map<Integer, Integer> map) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = climb(n - 1, map) + climb(n - 2, map);
        if (!map.containsKey(res)) {
            map.put(n, res);
        }
        return res;
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int l = 1;
        int r = 2;
        for (int i = 3; i <= n; i++) {
            int temp = r;
            r = l + r;
            l = temp;
        }
        return r;
    }

    public static void main(String[] args) {
        Problem70 p = new Problem70();
        System.out.println(p.climbStairs_(3));
    }
}
