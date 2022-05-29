package ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Problem26 p = new Problem26();
        System.out.println(p.removeDuplicates(new int[]{1,1,2}));
    }
}
