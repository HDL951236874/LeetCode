package Inorder;

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {

        if (root == null) return 0;
        int l_num = helper(root.left);
        int r_num = helper(root.right);
        if(l_num == -1 || r_num == -1) return -1;
        if (Math.abs(l_num - r_num) <= 1) {
            return Math.max(l_num, r_num) + 1;
        }else {
            return -1;
        }
    }
}
