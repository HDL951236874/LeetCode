package Top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem124 {
    int max_value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return helper(root);

    }
    public int helper(TreeNode treeNode){
        if(treeNode.right == null&&treeNode.left==null) return Math.max(treeNode.val, 0);
        int max_r = Math.max(helper(treeNode.right),0);
        int max_l = Math.max(helper(treeNode.left),0);
        max_value = Math.max(treeNode.val+max_l+max_r,max_value);
        return treeNode.val+Math.max(max_l,max_r);
    }
}
