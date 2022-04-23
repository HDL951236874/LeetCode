package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,1,root);
        return res;
    }

    public void helper(List<List<Integer>> res, int num_layer, TreeNode tree) {
        if (tree == null) return;
        if(res.size()<num_layer){
            res.add(new ArrayList<Integer>());
        }
        res.get(num_layer-1).add(tree.val);
        helper(res, num_layer+1,tree.left);
        helper(res, num_layer+1,tree.right);
    }
}
