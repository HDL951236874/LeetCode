package Top100;

import java.util.Map;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode tree, int deep) {
        if (tree == null) return deep;
        return Math.max(helper(tree.right,deep+1),helper(tree.left,deep+1));
    }

    public static void main(String[] args) {
        Problem104 p = new Problem104();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        System.out.println(p.maxDepth(treeNode));
    }
}
