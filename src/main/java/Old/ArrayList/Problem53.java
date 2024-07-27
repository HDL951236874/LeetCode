package Old.ArrayList;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

public class Problem53 {
    //this is the brute force method
    // this method can not be used since the time will exceed
    public int maxSubArray3(int[] nums) {
        if (nums.length == 1) return nums[0];
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = temp + nums[j];
                if (temp > min) min = temp;
            }
        }
        return min;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i]+current>nums[i]){
                current = nums[i]+current;
            }else {
                current = nums[i];
            }
            max = Math.max(max,current);
        }
        return max;
    }
}