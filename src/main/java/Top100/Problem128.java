package Top100;

import java.util.HashSet;
import java.util.Set;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max_length = 0;
        for (int i = 0; i < nums.length; i++) {
            int now_num = nums[i];
            int now_stack = 1;
            while (set.contains(now_num+1)){
                now_stack ++;
                now_num ++;
            }
            max_length = Math.max(max_length,now_stack);
        }
        return max_length;
    }
}
