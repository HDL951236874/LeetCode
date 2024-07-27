package algorithmLearn;

import java.util.Arrays;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r] == target){
                break;
            }else if(numbers[l]+numbers[r] > target){
                r--;
            }else if(numbers[l]+numbers[r] < target){
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }
}
