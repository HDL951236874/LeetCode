package Inorder;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if ((r1 == null && r2 != null) || (r2 == null && r1 != null)) return false;
        if (r1.val != r2.val) return false;
        boolean b1 = helper(r1.left, r2.left);
        boolean b2 = helper(r1.right, r2.right);
        return b1 && b2;
    }
}
