package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,1,res);
        return res;
    }

    public void helper(TreeNode node, int layer, List<Integer> res) {
        if(node == null) return;
        if (layer > res.size()) {
            res.add(node.val);
        }
        helper(node.right,layer+1,res);
        helper(node.left,layer+1,res);

    }
}
