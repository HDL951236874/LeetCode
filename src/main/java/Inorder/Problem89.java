package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }else {
            return helper(n);
        }
    }

    public List<Integer> helper(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 2) {
            res.add(0);
            res.add(1);
            res.add(3);
            res.add(2);
        } else {
            res = helper(n-1);
            for (int i = res.size() - 1; i >= 0; i--) {
                res.add(res.get(i) + (int) Math.pow(2, n-1));
            }
        }
        return res;
    }

}
