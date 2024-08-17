package ukg;

public class Question10 {
    public int jump(int[] nums) {
        int pos = 0;
        int res = 0;
        while(pos<nums.length-1){
            if(pos + nums[pos] >= nums.length -1) {
                res += 1;
                break;
            }
            int next = 0;
            int max = 0;
            for(int i =1;i<=nums[pos];i++){
                int x = pos+i+nums[pos+i];
                if(max <= x){
                    max = x;
                    next = i;
                }
            }
            pos += next;
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Question10 q = new Question10();
        System.out.println(q.jump(new int[]{2,3,0,1,4}));
    }
}
