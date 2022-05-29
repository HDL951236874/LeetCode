package ArrayList;

import java.util.*;

public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // for a subset problem solution, typically there are three methods
        // using the cascading
        // using the backtracking
        // using the bitmarking
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                Collections.sort(temp);
                res.add(temp);
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            set.add(res.get(i));
        }
        List<List<Integer>> final_res = new ArrayList<>(set);
        return final_res;
    }

    public static void main(String[] args) {
        Problem90 p = new Problem90();
        p.subsetsWithDup(new int[]{1, 2, 3});
    }
}
