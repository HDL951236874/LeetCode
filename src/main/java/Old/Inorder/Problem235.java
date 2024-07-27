package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, p, q, res);
        return res.get(0);
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> res) {
        if (root == null) return false;
        boolean b1 = helper(root.left, p, q, res);
        if (res.size() == 1)
            return true;
        boolean b2 = helper(root.right, p, q, res);
        if (res.size() == 1)
            return true;
        boolean b3 = false;
        if (root == p || root == q) b3 = true;
        if (b1 && b2 || b1 && b3 || b2 && b3) {
            res.add(root);
        }
        if(b1||b2||b3) return true;
        return false;
    }

    public static void main(String[] args) {
        Problem235 problem235 = new Problem235();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        problem235.lowestCommonAncestor(treeNode,treeNode,treeNode.left);
    }
}
