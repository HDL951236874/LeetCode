package Top100;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        //this can be down in stack
        if(root==null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root.left != null) {
            search(root.left, res);
        }
        res.add(root.val);

        if (root.right != null) {
            search(root.right, res);
        }
        return res;
    }

    public void search(TreeNode tree, List<Integer> res) {
        if (tree.left != null) {
            search(tree.left, res);
        }
        res.add(tree.val);

        if (tree.right != null) {
            search(tree.right, res);
        }
    }
}
