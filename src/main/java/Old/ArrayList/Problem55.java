package Old.ArrayList;

public class Problem55 {
    public boolean canJump2(int[] nums) {
        // this is the solution one, we can also use the greedy method
        if (nums.length == 1 && nums[0] == 0) return false;
        boolean f = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] + j > i) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    return false;
                }
                f = true;
            }
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int s = 0;
        while (s!=nums.length-1){
            int max = 0;
            int index = 0;
            for(int i =1;i<=nums[s];i++){
                if(s+i>=nums.length-1) return true;
                if(nums[s+i]+i>max){
                    max = nums[s+i]+i;
                    index = i;
                }
            }
            s += index;
            if(nums[s]==0&&s!= nums.length-1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem55 p = new Problem55();
        System.out.println(p.canJump(new int[]{0,1}));
    }
}
