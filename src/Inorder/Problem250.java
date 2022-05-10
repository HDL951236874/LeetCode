package Inorder;

public class Problem250 {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        backtrack(root);
        return this.res;
    }

    public boolean backtrack(TreeNode root) {
        if (root.left == null && root.right == null) {
            this.res++;
            return true;
        }
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;
        if (root.left != null) {
            b1 = backtrack(root.left);
            b3 = root.val == root.left.val;
        }
        if (root.right != null) {
            b2 = backtrack(root.right);
            b4 = root.val == root.right.val;
        }
        if (b1&&b2&&b3&&b4){
            this.res++;
            return true;
        }else {
            return false;
        }
    }
}
