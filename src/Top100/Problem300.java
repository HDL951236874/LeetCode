package Top100;

import java.util.Arrays;

public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Problem300 p = new Problem300();
        System.out.println(p.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
