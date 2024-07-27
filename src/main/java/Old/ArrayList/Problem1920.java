package Old.ArrayList;

import java.util.ArrayList;

public class Problem1920 {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i =0 ;i< nums.length;i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,4,3,2,41,1};
        for(int i:a){
            System.out.println(i);
        }
    }
}
