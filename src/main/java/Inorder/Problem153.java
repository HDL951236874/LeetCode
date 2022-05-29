package Inorder;

public class Problem153 {
    public int findMin(int[] nums) {
        if(nums.length ==1) return nums[0];
        int l = 0;
        int r = nums.length - 1;
        if (nums[0] < nums[nums.length-1]) return nums[0];
        else {
            while (l <= r) {
                int mid = l +(r-l)/2;
                if(nums[mid]>nums[mid+1]){
                    return nums[mid+1];
                }
                if(nums[mid-1]>nums[mid]){
                    return nums[mid];
                }
                if (nums[mid]>nums[0]){
                    l = mid+1;
                }
                if(nums[mid]<nums[0]){
                    r = mid -1;
                }
            }
            }
        return -1;
        }
    }
