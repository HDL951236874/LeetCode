package algorithmLearn;

public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid+1] == target){
                return mid+1;
            }
            else if (nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid + 1] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
