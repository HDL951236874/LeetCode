package Inorder;

import java.util.*;

public class Problem259 {
    int res = 0;

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] + nums[nums.length - 1] < target) this.res += nums.length - j - 1;
                else {
                    int l = j + 1;
                    int r = nums.length - 1;
                    if(l == r) continue;
                    while (l<=r){
                        int mid = l+(r-l)/2;
                        if(nums[mid]+nums[i]+nums[j]<target&&nums[mid+1]+nums[i]+nums[j]>=target){
                            this.res+=mid-j;
                            break;
                        }
                        else if(nums[mid+1]+nums[i]+nums[j]<target){
                            l = mid+1;
                        }else if(nums[mid]+nums[i]+nums[j]>=target){
                            r = mid -1;
                        }
                    }
                }
            }
        }
        return this.res;
    }

    public static void main(String[] args) {
        Problem259 problem259 = new Problem259();
        problem259.threeSumSmaller(new int[]{-2,0,1,3},2);
    }
}
