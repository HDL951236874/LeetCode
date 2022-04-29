package Top100;

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        boolean hasZero = false;
        boolean multiZero = false;
        int multi = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (hasZero == true) {
                    multiZero = true;
                    continue;
                }
                hasZero = true;
            } else {
                multi *= nums[i];
            }
        }
        int[] res = new int[nums.length];
        if(multiZero){
            return res;
        }
        if (hasZero) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) res[i] = multi;
                else res[i] = 0;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = multi / nums[i];
            }
        }
        return res;
    }

}
