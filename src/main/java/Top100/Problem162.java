package Top100;

public class Problem162 {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]-1<nums[i]&&nums[i+1]<nums[i]) return i;
        }
        return -1;
    }
}
