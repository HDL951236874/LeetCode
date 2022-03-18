package ArrayList;

import java.util.*;

public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1,-1};
            }
        }
//        ArrayList<Integer> test = new ArrayList<Integer>(nums.length);
//        Collections.addAll(test,)
        Set<Integer> test = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            test.add(nums[i]);
        }
        if(!test.contains(target)){
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = 0;
        if (nums[0] == target) {
            start = 0;
        } else {
            start = findStart(nums, target);
        }
        if (nums[nums.length - 1] == target) {
            end = nums.length - 1;
        } else {
            end = findEnd(nums, target);
        }
        return new int[]{start, end};
    }

    public int findStart(int[] nums, int target) {
        //5 7 7 8 8 10
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != target && nums[mid + 1] == target) {
                return mid + 1;
            } else if (nums[mid + 1] < target) {
                l = mid + 1;
            } else if (nums[mid] >= target) {
                r = mid - 1;
            }
            else {
                return -1;
            }
        }
        return -1;
    }

    public int findEnd(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid+1] != target && nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem34 p = new Problem34();
        System.out.println(p.searchRange(new int[]{1,3},1));
    }
}
