package Inorder;

import java.util.Map;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i + k; j++) {
                if(j>=nums.length) break;
                long res = (long)nums[j] - (long)nums[i];
                if(Math.abs(res)<= t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem220 problem220 = new Problem220();
        problem220.containsNearbyAlmostDuplicate(new int[]{2147483646,2147483647},3,3);
    }
}
