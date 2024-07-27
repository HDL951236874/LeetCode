package Old.ArrayList;

public class Problem1480 {
    public int[] runningSum(int[] nums) {
        int num = 0;
        int[] res = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            res[i] = num+nums[i];
            num = res[i];
        }
        return res;
    }
}
