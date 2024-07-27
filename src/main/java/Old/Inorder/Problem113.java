package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        helper(root,res,now,targetSum);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> now, int target) {
        if (root.left == null && root.right == null && target == root.val) {
            now.add(root.val);
            res.add(now);
            return;
        }
        if (root.left != null) {
            List<Integer> tmp1 = new ArrayList<>();
            tmp1.addAll(now);
            tmp1.add(root.val);
            helper(root.left,res,tmp1,target-root.val);
        }
        if (root.right != null) {
            List<Integer> tmp2 = new ArrayList<>();
            tmp2.addAll(now);
            tmp2.add(root.val);
            helper(root.right,res,tmp2,target-root.val);
        }
    }
}
