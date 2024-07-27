package Inorder;

public class Problem543 {
    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        backtrack(root);
        return max;
    }

    public int backtrack(TreeNode node) {
        if (node.left == null && node.right == null) {
            max = Math.max(1,max);
            return 1;
        }
        int l = 0;
        int r = 0;
        if (node.left != null) {
            l = backtrack(node.left);
        }
        if (node.right != null) {
            r = backtrack(node.right);
        }
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }
}
