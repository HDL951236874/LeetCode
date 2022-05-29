package Top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> final_res = new ArrayList<>();
        helper(res,1,root);
        for (int i = 0; i < res.size(); i++) {
            if(i%2 == 1){
                Collections.reverse(res.get(i));
                final_res.add(res.get(i));
            }else {
                final_res.add(res.get(i));
            }
        }
        return final_res;
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
