package Inorder;

import java.util.*;

public class Problem560 {
    int res = 0;

    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>(Arrays.asList(0)));
        for (int i = 1, sum = 0; i <= nums.length; i++) {
            sum += nums[i - 1];
            if (map.containsKey(sum)) {
                map.get(sum).add(i);
            } else map.put(sum, new ArrayList<>(Arrays.asList(i)));
        }
        for (Integer num : map.keySet()) {
            if (map.containsKey(num + k)) {
                List<Integer> list = map.get(num + k);
                List<Integer> list_ = map.get(num);
                for (int i = 0; i < list_.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list_.get(i) < list.get(j)) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
