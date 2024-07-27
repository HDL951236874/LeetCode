package Old.ArrayList;

import java.util.Arrays;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        //[-1,-1,1,1,3]
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        int min_distance = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int distance = target -sum;
                if (Math.abs(distance)<min_distance){
                    min_distance = Math.abs(distance);
                    res = sum;
                }
                if (distance<0){
                    r--;
                }else if(distance>0){
                    l++;
                }else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem16 p = new Problem16();
        System.out.println(p.threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }
}
