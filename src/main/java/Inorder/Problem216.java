package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();

        backtrack(res,now,n,1,k);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> now, int target, int limit, int k) {
        if (target < 0||now.size()>k) return;
        if (now.size() == k) {
            if (target == 0) {
                res.add(now);
            }
            return;
        }
        for (int i = limit; i <= 9; i++) {
            if (now.contains(i)) {
                continue;
            }
            List<Integer> temp = new ArrayList<>(now);
            temp.add(i);
            backtrack(res, temp, target - i, i + 1, k);
        }
    }
}
