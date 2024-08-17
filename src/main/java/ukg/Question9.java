package ukg;

public class Question9 {
    public boolean canJump(int[] nums) {
        if(nums.length ==1) return true;
        int p = 0;
        while(true){
            int step = nums[p];
            if(step == 0) return false;
            if(p+step >= nums.length -1) return true;
            int max = 0;
            int max_pos = 0;
            for(int i= 1;i<=step;i++){
                if(p+i+nums[p+i] >= max){
                    max = p+i+nums[p+i];
                    max_pos = i;
                }
            }
            p += max_pos;
        }
    }
    /**
     * The second way is to find without the list can handle the 0 problem
     * */

    public static void main(String[] args) {
        Question9 q = new Question9();
        System.out.println(q.canJump(new int[]{1,1,2,2,0,1,1}));
    }
}
