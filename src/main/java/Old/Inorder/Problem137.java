package Inorder;

import java.util.*;

public class Problem137 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return 3*set.stream().reduce(Integer::sum).orElse(0) - Arrays.stream(nums).sum();

    }
}
