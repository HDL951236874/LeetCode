package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
                if(i-map.get(nums[i])<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
