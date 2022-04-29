package Top100;

import java.util.Arrays;

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = l + k - 1;
        int[] ini = max_index(nums, l, r);
        int max_index = ini[0];
        int max = ini[1];
        while (r < nums.length) {
            if(max_index>=l){
                if(max<= nums[r]){
                    max = nums[r];
                    max_index = r;
                }
            }else {
                int[] new_list = max_index(nums,l,r);
                max_index = new_list[0];
                max = new_list[1];
            }
            res[l] = max;
            l++;
            r++;
        }
        return res;
    }

    public int[] max_index(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] >= max) {
                max_index = i;
                max = nums[i];
            }
        }
        return new int[]{max_index, max};
    }

    public static void main(String[] args) {
        Problem239 p = new Problem239();
        System.out.println(p.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
