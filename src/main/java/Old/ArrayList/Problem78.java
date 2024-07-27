package Old.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem78 {
    // you can also try the backtrack
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int length = res.size();
            for (int j = 0; j < length; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem78 p = new Problem78();
        p.subsets(new int[]{1,2,3});
    }
}
