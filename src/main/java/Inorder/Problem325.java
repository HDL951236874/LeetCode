package Inorder;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class Problem325 {
    //this is a good question
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] sum_list = new int[nums.length+1];
        sum_list[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum_list[i+1] = sum;
            if (!map.containsKey(sum)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(sum, temp);
            } else {
                map.get(sum).add(i);
            }
        }
        int res = 0;
        for (int i = 0; i < sum_list.length; i++) {
            if (map.containsKey(k + sum_list[i])) {
                int now = Collections.max(map.get(k + sum_list[i]));
                res = Math.max(res, now - i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem325 problem325 = new Problem325();
        System.out.println(problem325.maxSubArrayLen(new int[]{1,-1,5,-2,3},3));
    }
}
