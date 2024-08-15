package ukg;

public class Question5 {
    /**
     * you can you a map to count or you can use moore voting
     * if the number is tha majority in the list, the count should be over 0
     * */

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int i =0; i< nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
