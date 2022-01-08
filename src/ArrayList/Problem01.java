package ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {
    //use map can improve the performance
//    public int[] twoSum(int[] nums, int target) {
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[]{nums[i],nums[j]};
//                }
//            }
//        }
//        return new int[]{};
//    }
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;i++){
            map.put(target-nums[i],i);
        }
        for(int i =0;i<nums.length;i++){
            if (map.containsKey(nums[i])&&i!=map.get(nums[i])){
                return new int[]{i,map.get(nums[i])};
            }
        }
        return new int[]{};
    }
}
