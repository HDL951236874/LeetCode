package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int p = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i==nums.length-1){
                if(nums[i]==p){
                    res.add(String.valueOf(p));
                }else {
                    res.add(String.valueOf(p) + "->" + String.valueOf(nums[i]));
                }
            }
            if (i != nums.length - 1 && nums[i + 1] - nums[i] != 1) {
                if (nums[i] == p) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(String.valueOf(p) + "->" + String.valueOf(nums[i]));
                }
                p = nums[i + 1];
            }
        }
        return res;
    }
}
