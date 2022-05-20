package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem416 {
    int target = 0;

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        if (Arrays.stream(nums).sum() % 2 != 0) return false;
        Arrays.sort(nums);
        target = Arrays.stream(nums).sum() / 2;
        int l = 0;
        int r = 0;
        List<Integer> temp = new ArrayList<>();
        while (r < nums.length) {
            if (r == nums.length-1 || nums[r] != nums[r + 1]) {
                if ((r - l + 1) % 2 == 1) {
                    temp.add(nums[r]);
                }
                l = r + 1;
            }
            r++;
        }
        if(temp.size() == 0) return true;
        return backtrack(temp, 0, 0);
    }

    public boolean backtrack(List<Integer> nums, int now, int index) {
        if (now == target) return true;
        if (now > target) return false;
        for (int i = index; i < nums.size(); i++) {
            if (now + nums.get(index) > target) break;
            if (backtrack(nums, now + nums.get(index), i + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem416 problem416 = new Problem416();
        System.out.println(problem416.canPartition(new int[]{2, 2, 1, 1}));
    }
}
