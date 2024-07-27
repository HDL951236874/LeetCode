package Inorder;

import java.util.Arrays;
import java.util.Map;

public class Problem209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) return 0;
        int l = 0;
        int r = 0;
        int sum = nums[0];
        int min = nums.length;
        while (r < nums.length && l < nums.length) {
            if (target > sum) {
                r++;
                if (r < nums.length) {
                    sum += nums[r];
                }
            }
            if (target <= sum) {
                min = Math.min(min, r-l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Problem209 problem209 = new Problem209();
        problem209.minSubArrayLen(213,new int[]{12,28,83,4,25,26,25,2,25,25,25,12});
    }

}
