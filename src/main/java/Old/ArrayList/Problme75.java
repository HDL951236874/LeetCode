package Old.ArrayList;

public class Problme75 {
    public void sortColors(int[] nums) {
    for(int i = 0;i<nums.length;i++){
        for(int j = i+1;j<nums.length;j++){
            if(nums[j]<nums[i]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
    }
}
