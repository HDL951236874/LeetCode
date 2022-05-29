package Top100;

import java.util.Arrays;

public class Problem268 {
    public int missingNumber(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        if(max*(1+max)/2 - Arrays.stream(nums).sum() == 0)
            if(max == nums.length) return 0;
            if(max < nums.length) return max+1;
        else {
            return max*(1+max)/2 - Arrays.stream(nums).sum();
        }
    }
}
