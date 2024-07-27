package Old.ArrayList;

import java.util.Arrays;

public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] table = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length){
                table[nums[i]-1] = 1;
            }
        }
        for(int i =0;i<table.length;i++){
            if(table[i]==0){
                return i+1;
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        System.out.println(p.firstMissingPositive(new int[]{2147483647}));
    }
}
