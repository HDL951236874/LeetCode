package Inorder;

import sun.util.resources.cldr.nus.CalendarData_nus_SD;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root);
    }

    public int helper(TreeNode root) {
        int l_num = Integer.MAX_VALUE;
        int r_num = Integer.MAX_VALUE;
        if(root.right == null && root.left == null) return 1;
        if (root.left != null)
            l_num = helper(root.left);
        if (root.right != null)
            r_num = helper(root.right);

        return Math.min(l_num, r_num) + 1;
    }
}
