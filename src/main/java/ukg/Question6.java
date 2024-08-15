package ukg;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Question6 {
    public void rotate(int[] nums, int k) {
        int time = k%nums.length;
        int[] last = Arrays.stream(nums).limit(nums.length - time).toArray();
        int[] front = Arrays.stream(nums).skip(nums.length - time).toArray();
        IntStream.range(0, front.length).forEach(i -> {nums[i] = front[i];});
        IntStream.range(0,nums.length - time).forEach(i->{nums[front.length+i] = last[i];});
    }
    public void rotate1(int[] nums, int k){
        k = nums.length - k%nums.length;
        int[] con = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if(i<k){
                con[i] = nums[i];
            } else {
                nums[i-k] = nums[i];
            }
        }
        for (int i = 0; i < con.length; i++) {
            nums[nums.length-k+i] = con[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Question6 q = new Question6();
        q.rotate1(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
