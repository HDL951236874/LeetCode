package Inorder;

public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
