package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int num : nums)temp.add(num);
        Collections.sort(temp);
        for (int i = 0; i < temp.size()-1; i++) {
            if(temp.get(i).equals(temp.get(i+1))) return temp.get(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem287 p = new Problem287();
        System.out.println(p.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
