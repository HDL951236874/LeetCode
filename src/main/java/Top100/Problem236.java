package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> res = new ArrayList<>();
        helper(root,p.val,q.val,res);
        return res.get(0);
    }

    public boolean helper(TreeNode root, int p, int q, List<TreeNode> res) {
        if (root == null) return false;

        Boolean l = helper(root.left, p, q, res);
        Boolean r = helper(root.right, p, q, res);
        if (!l&&!r&&root.val!=p&&root.val!=q) return false;
        if (l && r) res.add(root);
        if ((root.val == p || root.val == q)&&(l||r)) {
            res.add(root);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem236 p = new Problem236();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(p.lowestCommonAncestor(root,root.left,root.left.right.right));
    }
}
