package Old.Contest;

import java.util.Arrays;

public class contest6067 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        long l = 0;
        long r = sum;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            l += nums[i];
            r -= nums[i];
            if (l >= r) res++;
        }
        return res;
    }
}
