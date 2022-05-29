package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int r = 1;
        int l = 0;
        while (r < nums.length) {
            if (nums[r] != nums[r - 1] || r == nums.length - 1) {
                int len = r - l;
                if (res.size() == 0||len < res.get(res.size() - 1)) {
                    res.add(len);
                    l = r;
                    r++;
                    continue;
                }
                for (int i = 0; i < k; i++) {
                    if (len > res.get(i)) {
                        res.add(i, len);
                        break;
                    }
                }
                l = r;
            }
            r++;
        }
        int[] res_ = new int[k];
        for (int i = 0; i < k; i++) {
            res_[i] = res.get(i);
        }
        return res_;
    }

}
