package ukg;

import java.util.Arrays;

public class Question13 {
    public int[] productExceptSelf(int[] nums) {
        long count = Arrays.stream(nums).filter(i -> i == 0).count();
        if(count >= 2) return new int[nums.length];
        else if(count == 1) {
            int mul = 1;
            int pos = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    mul *= nums[i];
                } else {
                    pos = i;
                }
            }
            int[] res = new int[nums.length];
            res[pos] = mul;
            return res;
        }else {
            int reduce = Arrays.stream(nums).reduce(1, (a, b) -> a * b);
            for(int i = 0; i < nums.length; i++) {
                nums[i] = reduce/nums[i];
            }
            return nums;
        }
    }
}
