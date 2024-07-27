package Inorder;

import java.util.Arrays;

public class Problem439 {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            if(nums[0] == target || -1*nums[0] == target) {
                if(nums [0] == 0) return 2;
                else return 1;
            }

            else return 0;
        }
        int[] temp = Arrays.copyOfRange(nums, 1, nums.length);
        return findTargetSumWays(temp, target - nums[0]) + findTargetSumWays(temp, target + nums[0]);
    }
}
