package ukg;

import java.util.HashSet;

public class Question3 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int[] copy = nums.clone();
        int p = 0;
        for (int i = 0; i < copy.length; i++) {
            if(!integers.contains(copy[i])){
               nums[p++] = copy[i];
               integers.add(copy[i]);
            }
        }
        return p;
    }
    /**
     * Here is a simple way, if you can ensure that the length of your for loop will not change and the
     * speed you iterate through is faster than changing the elements in the front side of the list you can do it
     * */
    public int removeDuplicates1(int[] nums) {
        int p = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
