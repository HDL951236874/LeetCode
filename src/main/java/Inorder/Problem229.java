package Inorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> re =new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for(Integer num : map.keySet()){
            if(map.get(num)>nums.length/3){
                re.add(num);
            }
        }
        return re;
    }
}
