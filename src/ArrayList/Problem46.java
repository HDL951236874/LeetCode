package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// the combination problem is always solved by the backtrack
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> now = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums){
            left.add(i);
        }
        backtrack(now,left,res);
        return res;
    }

    // the backtrack through is based on the tree data structure
    public void backtrack(List<Integer> now, List<Integer> left, List<List<Integer>> res) {
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
        Problem46 p = new Problem46();
        List<List<Integer>> res = p.permute(new int[]{1,2,3});
        System.out.println(1);
    }
}
