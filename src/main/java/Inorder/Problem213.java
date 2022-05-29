package Inorder;

public class Problem213 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] temp1 = new int[nums.length - 1];
        int[] temp2 = new int[nums.length - 1];
        for (int i = 0, x = 0, y = 0; i < nums.length; i++) {
            if (i != 0) {
                temp1[x] = nums[i];
                x++;
            }
            if (i != nums.length - 1) {
                temp2[y] = nums[i];
                y++;
            }
        }
        return Math.max(helper(temp1), helper(temp2));
    }

    public int helper(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = nums[0];
        int r = Math.max(nums[0], nums[1]);
        int p = 2;
        while (p < nums.length) {
            int temp = r;
            r = Math.max(r, l + nums[p]);
            l = temp;
            p++;
        }
        return r;
    }
}
