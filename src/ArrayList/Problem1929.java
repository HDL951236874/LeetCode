package ArrayList;

public class Problem1929 {

    public int[] getConcatenation(int[] nums) {
        int[] res = new int[2* nums.length];
        for (int i =0; i<res.length;i++){
            if (i<nums.length){
                res[i] = nums[i];
            }else {
                res[i] = nums[i-nums.length];
            }
        }
        return res;
    }
//    public int[] getConcatenation(int[] nums) {
//        int[] ans = new int[2*nums.length];
//
//        for(int i = 0; i < nums.length; i++) {
//            // ans[i] = nums[i];
//            ans[i + nums.length] = ans[i] = nums[i];
//        }
//
//        return ans;
//    }
}
