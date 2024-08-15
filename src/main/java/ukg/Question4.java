package ukg;

import java.util.HashMap;
import java.util.Map;

public class Question4 {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int p = 0;
        for(int i = 0;i < nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            if(map.get(nums[i]) < 3 ) {
                nums[p++] = nums[i];
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        return p;
    }
    public int removeDuplicates2(int[] nums) {
        int p = 2;
        int[] copy = nums.clone();
        for(int i = 2;i < copy.length;i++) {
            if(copy[i] != copy[i-1] || (copy[i] == copy[i-1] && copy[i-2] != copy[i])) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

}
