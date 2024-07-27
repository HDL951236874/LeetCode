package Old.ArrayList;

import java.util.Arrays;
// this is a good question!
public class Problem33 {
    public int search(int[] nums, int target) {
        if(nums.length == 1){return target==nums[0]?0:-1;}
        int point = findThePoint(nums, 0, nums.length - 1);
        if (point == -1){
           return binarySearch(nums,0,nums.length-1,target);
        }else if(nums[nums.length-1]<target){
            return binarySearch(nums,0,point-1,target);
        }else {
            return binarySearch(nums,point,nums.length-1,target);
        }
    }

    public int findThePoint(int[] nums, int l, int r) {
        if (r - l == 1) {
            if (nums[r] < nums[l]) {
                return r;
            }
            return -1;
        }
        int mid = (l + r) / 2;
        int res1 = findThePoint(nums, l, mid);
        int res2 = findThePoint(nums, mid, r);
        if (res1 == -1 && res2 == -1) {
            return -1;
        } else if (res1 != -1) {
            return res1;
        } else {
            return res2;
        }
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem33 p = new Problem33();
        System.out.println(p.search(new int[]{2, 3, 4, 5, 6, 0, 1}, 4));
    }
}
