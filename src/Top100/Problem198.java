package Top100;

public class Problem198 {
    public int rob_(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    public int helper(int[] nums, int index) {
        if (index == 0) return nums[0];
        if (index == 1) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, index - 1), helper(nums, index - 2) + nums[index]);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max1 = nums[0];
        int max2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max2_temp = Math.max(max2, max1 + nums[i]);
            max1 = max2;
            max2 = max2_temp;
        }
        return max2;
    }
}
