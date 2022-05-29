package Inorder;

public class Problem156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = new TreeNode(root.val);
        TreeNode newNode = new TreeNode(0);
        while (root.left != null) {
            newNode = new TreeNode(root.left.val);
            if (root.right != null)
                newNode.left = new TreeNode(root.right.val);
            newNode.right = temp;
            temp = newNode;
            root = root.left;
        }
        return newNode;
    }
}
