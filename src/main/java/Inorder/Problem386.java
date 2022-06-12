package Inorder;

import java.util.*;

public class Problem386 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            for (Integer num : map.keySet()) {
                if (nums[i] % num == 0) {
                    if (list.size() < map.get(num).size()) {
                        list.clear();
                        list.addAll(map.get(num));
                    }
                }
            }
            list.add(nums[i]);
            map.put(nums[i],list);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer num : map.keySet()) {
            if (map.get(num).size() > res.size()) res = map.get(num);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem386 problem386 = new Problem386();
        problem386.largestDivisibleSubset(new int[]{1,2,4,8});
    }
}
