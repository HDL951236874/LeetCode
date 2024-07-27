package Rework.Contest;

public class Contest2932 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j])) {
                    res = Math.max(res, nums[i] ^ nums[j]);
                }
            }
        }
        return res;
    }
}
