package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Porblem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();
        if (candidates.length == 1 && candidates[0] == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        int index = 0;

        backtrack(candidates,target,res,now,index);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> now, int index) {
        int value = now.stream().collect(Collectors.summingInt(Integer::intValue));
        if(value < target){
            for(int i = index;i<candidates.length;i++){
                List<Integer> temp = new ArrayList<Integer>(now);
                temp.add(candidates[i]);
                backtrack(candidates,target,res,temp,i);
            }
        }else if(value>target){
            return;
        }else {
            res.add(now);
        }
    }

    public static void main(String[] args) {
        Porblem39 p = new Porblem39();
        int[] candidate = new int[]{1,2,3,4};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        int index = 0;
        int target = 4;
        p.backtrack(candidate,target,res,now,index);
        System.out.println(res);
    }

}
