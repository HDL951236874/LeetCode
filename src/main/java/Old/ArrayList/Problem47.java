package Old.ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> now = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i : nums){
            left.add(i);
        }
        backtrack(now,left,res);
        List<List<Integer>> finalRes = new ArrayList<>(res);
        return finalRes;

    }
    public void backtrack(List<Integer> now, List<Integer> left, Set<List<Integer>> res) {
        if (left.size() == 1){
            now.add(left.get(0));
            res.add(now);
        }
        for (int i = 0; i < left.size(); i++) {
            List<Integer> tempNow = new ArrayList<>(now);
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j< left.size();j++){
                if(j!=i){
                    newList.add(left.get(j));
                }
            }
            tempNow.add(left.get(i));
            backtrack(tempNow, newList,res);
        }
    }

    public static void main(String[] args) {
        Problem47 p = new Problem47();
        List<List<Integer>> res = p.permuteUnique(new int[]{1,1,2});
        System.out.println(1);
    }

}
