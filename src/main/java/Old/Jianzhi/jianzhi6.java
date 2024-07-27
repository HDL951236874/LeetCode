package Jianzhi;

import java.util.HashMap;
import java.util.Map;

public class jianzhi6 {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = fib(n - 1) + fib(n - 2);
        if (!map.containsKey(n))
            map.put(n, res);
        return res;
    }
}
