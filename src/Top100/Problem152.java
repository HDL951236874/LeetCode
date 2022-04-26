package Top100;

public class Problem152 {
    public int maxProduct_(int[] nums) {
        // the time complexity of this method is too big
        int final_res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                final_res = Math.max(get_res(nums, i, j), final_res);
            }
        }
        return final_res;
    }

    public int get_res(int[] nums, int begin, int end) {
        if (begin == end) return nums[begin];
        int res = 1;

        for (int i = begin; i <= end; i++) {
            res *= nums[i];
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp_min = Math.min(Math.min(nums[i],nums[i]*min),nums[i]*max);
            int temp_max = Math.max(Math.max(nums[i],nums[i]*min),nums[i]*max);
            res = Math.max(res,temp_max);
            max = temp_max;
            min = temp_min;
        }
        return res;
    }
}