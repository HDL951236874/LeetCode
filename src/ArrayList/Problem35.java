package ArrayList;

public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        if(target == nums[nums.length-1]) return nums.length-1;
        if(target > nums[nums.length-1]) return nums.length;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==target){
                return i;
            }else if(nums[i]<target&&nums[i+1]>target){
                return i+1;
            }
        }
        return -1;
    }
}
