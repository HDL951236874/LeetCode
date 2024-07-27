package Old.Contest;

import java.util.Arrays;

public class contest2256 {
    public int minimumAverageDifference(int[] nums) {
        long min = Integer.MAX_VALUE;
        int min_index = 0;
        long sum = Arrays.stream(nums).sum();
        long acc = 0;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            long res = 0;
            if (i != nums.length - 1) {
                res = Math.abs(acc / (long)(i + 1) - (sum - acc) /(long) (nums.length - i - 1));
            }else {
                res = Math.abs(sum/(long)nums.length);
            }
            if (res < min) {
                min = res;
                min_index = i;
            }
        }
        return min_index;
    }
}
