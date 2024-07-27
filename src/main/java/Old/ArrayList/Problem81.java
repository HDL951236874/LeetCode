package Old.ArrayList;

public class Problem81 {
    // in this question we use a quiet simple way
    public boolean search(int[] nums, int target) {
        //1 0 1 1 1
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target || nums[l] == target || nums[r] == target) {
                return true;
            }
            if (nums[mid] > nums[l] || nums[mid]>nums[r]) {
                if (target > nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l] || nums[mid]<nums[r]) {
                if (target > nums[mid] && target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }else if(nums[mid] == nums[r] &&nums[mid] == nums[l]){
                for (int i = l; i <=r; i++) {
                    if(target == nums[i]) return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem81 p = new Problem81();
        p.search(new int[]{3,3,0,1,3}, 1);
    }
}
