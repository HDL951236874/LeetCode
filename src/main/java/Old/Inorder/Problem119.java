package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        return backtrack(rowIndex);
    }
    public List<Integer> backtrack(int n){
        List<Integer> res = new ArrayList<>();
        if(n == 0){
            res.add(1);
            return res;
        }
        if(n == 1){
            res.add(1);
            res.add(1);
            return res;
        }
        List<Integer> tmp = backtrack(n-1);
        res.add(1);
        for (int i = 0; i < tmp.size()-1; i++) {
            res.add(tmp.get(i)+tmp.get(i+1));
        }
        res.add(1);
        return res;
    }
}
