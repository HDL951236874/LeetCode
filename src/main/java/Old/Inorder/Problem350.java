package Inorder;

import java.util.*;

public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small = nums1.length >= nums2.length ? nums2 : nums1;
        int[] big = nums1.length >= nums2.length ? nums1 : nums2;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < big.length; i++) {
            int d_v = temp.getOrDefault(big[i], 0);
            temp.put(big[i], d_v + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < small.length; i++) {
            if (temp.containsKey(small[i]) && temp.get(small[i]) > 0) {
                res.add(small[i]);
                temp.put(small[i], temp.get(small[i]) - 1);
            }
        }
        int[] final_res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            final_res[i] = res.get(i);
        }
        return final_res;
    }
}
