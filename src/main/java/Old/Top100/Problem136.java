package Top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        for(int num: map.keySet()){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
