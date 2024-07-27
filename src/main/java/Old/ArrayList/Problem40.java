package Old.ArrayList;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

import java.util.stream.Collectors;
//TODO: the combination table method
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();


        Arrays.sort(candidates);
        if (candidates.length*candidates[candidates.length-1]<target) return new ArrayList<>();

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> now = new ArrayList<>();
        int index = 0;
        backtrack(candidates,target,res,now,index);
//        String[] array=set.toArray(new String[0]);
//        System.out.println(Arrays.toString(array));
//        List<Integer> resFinal = res.toArray(new List<Integer>(0));
        List<List<Integer>> finalRes = new ArrayList<>();
        for(List<Integer> instance:res){
            finalRes.add(instance);
        }
        return finalRes;
    }

    public void backtrack(int[] candidates,int target, Set<List<Integer>> res, List<Integer> now, int index) {
        //10,1,2,7,6,1,5
        //1,1,2,5,6,7,10
        int value = now.stream().collect(Collectors.summingInt(Integer::intValue));
        if(value<target){
            for(int i = index;i<candidates.length;i++){
                if (i!=index&&candidates[i] == candidates[i-1]){
                    continue;
                }
                List<Integer> temp = new ArrayList<Integer>(now);
                temp.add(candidates[i]);
                backtrack(candidates,target,res,temp,i+1);
            }
            return;
        }else if(value> target){
            return;
        }else {
            res.add(now);
        }
    }

    public static void main(String[] args) {
        Problem40 p = new Problem40();
        int[] candidate = new int[]{10,1,2,7,6,1,5};
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> now = new ArrayList<>();
        int index = 0;
        int target = 8;
        p.combinationSum2(candidate,target);
        p.backtrack(candidate,target,res,now,index);
        System.out.println(res);
//        Set<String> set = new HashSet<>();
//        set.add("value1");
//        set.add("value2");
//        set.add("value3");
//        //Set-->数组
//        String[] array=set.toArray(new String[0]);
//        System.out.println(Arrays.toString(array));
    }
}
