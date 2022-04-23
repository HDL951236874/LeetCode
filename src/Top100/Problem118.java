package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                res.add(temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                List<Integer> lastList = res.get(i - 2);
                for (int j = 0; j < i - 2; j++) {
                    temp.add(lastList.get(j) + lastList.get(j + 1));
                }
                temp.add(1);
                res.add(temp);
            }
        }
        return res;
    }
}
