package Inorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem129 {
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,0,res);
        return res.stream().reduce(Integer::sum).orElse(0);
    }

    public void helper(TreeNode treeNode, int now, List<Integer> res) {
        if (treeNode.left == null && treeNode.right == null) {
            res.add(now*10+treeNode.val);
        }
        if (treeNode.left != null) {
            helper(treeNode.left, now * 10 + treeNode.val, res);
        }
        if (treeNode.right != null) {
            helper(treeNode.right, now * 10 + treeNode.val, res);
        }
    }
}
