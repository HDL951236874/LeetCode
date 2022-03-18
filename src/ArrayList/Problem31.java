package ArrayList;

public class Problem31 {
    public void nextPermutation(int[] nums) {
        //[1,3,2]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                //aim = i
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        for (int m = i + 1; m < nums.length; m++) {
                            for (int n = m + 1; n < nums.length; n++) {
                                if (nums[n] < nums[m]) {
                                    int temp2 = nums[n];
                                    nums[n] = nums[m];
                                    nums[m] = temp2;
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
        for (int m = 0; m < nums.length; m++) {
            for (int n = m + 1; n < nums.length; n++) {
                if (nums[n] < nums[m]) {
                    int temp3 = nums[n];
                    nums[n] = nums[m];
                    nums[m] = temp3;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Problem31 p = new Problem31();
        p.nextPermutation(new int[]{3,2,1});
    }
}
