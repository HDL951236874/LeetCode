package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < primes.length; i++) {
            map.put(primes[i], 0);
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer num : map.keySet()) {
                min = Math.min(min, dp[map.get(num)] * num);
            }
            for (Integer num: map.keySet()) {
                if(dp[map.get(num)] == min) {
                    map.put(num,map.get(num)+1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Problem313 problem313 = new Problem313();
        System.out.println(problem313.nthSuperUglyNumber(10, new int[]{2, 3, 5}));
    }
}
