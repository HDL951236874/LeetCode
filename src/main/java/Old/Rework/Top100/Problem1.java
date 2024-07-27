package Rework.Top100;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int x = target - nums[i];
            if(map.containsKey(x)){
                return new int[]{i, map.get(x)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
