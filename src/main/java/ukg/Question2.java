package ukg;

import java.util.Arrays;

public class Question2 {
    public int removeElement(int[] nums, int val) {
        int[] nums_copy = nums.clone();
        Arrays.fill(nums, 0);
        int p = 0;
        for (int i = 0; i < nums_copy.length; i++) {
            if(nums_copy[i] !=val ){
                nums[p] = nums_copy[i];
                p ++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        q.removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }
}
