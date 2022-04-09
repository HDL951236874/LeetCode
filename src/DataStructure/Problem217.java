package DataStructure;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
