package Inorder;

import java.util.*;

public class contest2239 {
    public int findClosestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < max) {
                max = Math.abs(nums[i]);
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                list = temp;
                continue;
            }
            if (Math.abs(nums[i]) == max) {
                list.add(nums[i]);
            }
        }
        return Collections.max(list);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-4,-2,1,4,8};
        contest2239 contest2239 = new contest2239();
        contest2239.findClosestNumber(a);
    }
}
