package Top100;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem163 {
    public List<String> findMissingRanges_(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        List<Integer> nums_list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums_list.add(nums[i]);
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            if (i == lower) {
                if (!nums_list.contains(i)) {
                    l.add(i);
                    if (nums_list.contains(i + 1)) {
                        r.add(i);
                    }
                }
            }
            if (i == upper) {
                if (!nums_list.contains(i)) {
                    r.add(i);
                    if (nums_list.contains(i - 1)) {
                        l.add(i);
                    }
                }
            }
            if (i != lower && i != upper) {
                if (!nums_list.contains(i) && nums_list.contains(i - 1)) {
                    l.add(i);
                }
                if (!nums_list.contains(i) && nums_list.contains(i + 1)) {
                    r.add(i);
                }
            }
        }
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == r.get(i)) {
                res.add(String.valueOf(l.get(i)));
            } else {
                res.add(String.valueOf(l.get(i)) + "->" + String.valueOf(r.get(i)));
            }
        }
        return res;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            if(lower == upper){
                res.add(String.valueOf(lower));
            }else {
                res.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i==0&&nums[i]>lower){
                if (nums[i] - lower == 1) {
                    res.add(String.valueOf(nums[i] - 1));
                } else {
                    res.add(String.valueOf(lower) + "->" + String.valueOf(nums[i]-1));
                }
            }

            if (i>= 1&&nums[i] - nums[i - 1] > 1) {
                if (nums[i] - nums[i - 1] == 2) {
                    res.add(String.valueOf(nums[i] - 1));
                } else {
                    res.add(String.valueOf(nums[i - 1]+1) + "->" + String.valueOf(nums[i]-1));
                }
            }
            if(i==nums.length-1&&nums[i]<upper){
                if (upper - nums[i] == 1) {
                    res.add(String.valueOf(nums[i] + 1));
                } else {
                    res.add(String.valueOf(nums[i]+1) + "->" + String.valueOf(upper));
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        Problem163 p = new Problem163();
        System.out.println(p.findMissingRanges(new int[]{1,3}, 0, 9));
    }
}
