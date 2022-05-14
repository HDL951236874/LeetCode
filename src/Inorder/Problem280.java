package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem280 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] small;
        int[] big;
        if (nums.length % 2 == 0) {
            small = Arrays.copyOfRange(nums, 0, nums.length / 2);
            big = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        } else {
            small = Arrays.copyOfRange(nums, 0, nums.length / 2 + 1);
            big = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = small[i / 2];
            } else {
                nums[i] = big[(int) (i - 1) / 2];
            }
        }
    }
}
