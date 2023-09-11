package Top100;


import java.util.HashMap;
import java.util.Map;

public class Problem169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int default_value = map.getOrDefault(nums[i],0);
            map.put(nums[i],default_value+1);
        }
        int max = 0;
        int max_index = 0;
        for (Integer num: map.keySet()) {
            if(map.get(num)>max){
                max = map.get(num);
                max_index = num;
            }
        }
        return max_index;
    }

    public static void main(String[] args) {
        Problem169 p = new Problem169();
        System.out.println(p.majorityElement(new int[]{3,3,4}));
    }

}
